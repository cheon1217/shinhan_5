package team3.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import team3.util.DBUtil;

public class CarsService {
    private Connection conn = DBUtil.getConnection();

    public List<String> getAllCarsWithStatus() {
        List<String> list = new ArrayList<>();
        String sql = """
            SELECT c.carId, c.model, c.carNum,
                   CASE
                       WHEN EXISTS (
                           SELECT 1
                           FROM UsersCars uc
                           WHERE uc.carId = c.carId
                             AND uc.status != '반납완료'
                             AND SYSDATE BETWEEN uc.startdate AND uc.enddate
                       ) THEN '대여 중'
                       ELSE '사용 가능'
                   END AS availability
            FROM Cars c
        """;

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String line = String.format("🚘 차량ID: %-4d | 모델명: %-20s | 번호판: %-10s | 상태: %s",
                    rs.getInt("carId"),
                    rs.getString("model"),
                    rs.getString("carNum"),
                    rs.getString("availability")
                );
                list.add(line);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<String> getAvailableCarsByDate(Date date) {
        List<String> list = new ArrayList<>();
        String sql = """
            SELECT c.carId, c.model, c.carNum
            FROM Cars c
            WHERE NOT EXISTS (
                SELECT 1
                FROM UsersCars uc
                WHERE uc.carId = c.carId
                  AND uc.status != '반납완료'
                  AND ? BETWEEN uc.startdate AND uc.enddate
            )
        """;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, date);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String line = String.format("🚘 차량ID: %-4d | 모델명: %-20s | 번호판: %-10s",
                    rs.getInt("carId"),
                    rs.getString("model"),
                    rs.getString("carNum")
                );
                list.add(line);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

	public List<String> getAvailableCarsByDateRange(Date start, Date end) {
		List<String> list = new ArrayList<>();
        String sql = """
            SELECT c.carId, c.model, c.carNum
            FROM Cars c
            WHERE NOT EXISTS (
                SELECT 1
                FROM UsersCars uc
                WHERE uc.carId = c.carId
                  AND uc.status != '반납완료'
                  AND NOT (
        		     uc.enddate < ? OR uc.startdate > ?
                  )
            )
        """;
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, start);
            pstmt.setDate(2, end);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String line = String.format("🚘 차량ID: %-4d | 모델명: %-20s | 번호판: %-10s",
                    rs.getInt("carId"),
                    rs.getString("model"),
                    rs.getString("carNum")
                );
                list.add(line);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		return list;
	}


}
