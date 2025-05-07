package team3.analystics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import team3.util.DBUtil;

public class JoinAnalytics {
	 static Connection conn = DBUtil.getConnection();

	 	// 마이페이지: 로그인한 사용자의 개인정보 + 대여 이력 조회
	    public static void showUserMyPage(int userId) {
	        String sql = """
	            SELECT u.email, u.age, u.score, c.model, uc.startdate, uc.enddate, uc.status
	            FROM Users u
	            LEFT JOIN UsersCars uc ON u.userId = uc.userId
	            LEFT JOIN Cars c ON uc.carId = c.carId
	            WHERE u.userId = ?
	        """;
	        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, userId);
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                System.out.printf("Email: %s | 나이: %d | 점수: %d\n차량: %s | 기간: %s ~ %s | 상태: %s\n",
	                        rs.getString("email"), rs.getInt("age"), rs.getInt("score"),
	                        rs.getString("model"), rs.getDate("startdate"), rs.getDate("enddate"), rs.getString("status"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    // 전체 대여 내역 조회
	    public static void showAllRentals() {
	        String sql = """
	            SELECT uc.ucno, u.email, c.model, uc.startdate, uc.enddate, uc.status, p.name AS payment_method
	            FROM UsersCars uc
	            JOIN Users u ON uc.userId = u.userId
	            JOIN Cars c ON uc.carId = c.carId
	            JOIN Payments p ON uc.paymentsId = p.paymentsId
	        """;
	        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                System.out.printf("[%d] %s - %s (%s ~ %s, %s)\n",
	                        rs.getInt("ucno"), rs.getString("email"), rs.getString("model"),
	                        rs.getDate("startdate"), rs.getDate("enddate"), rs.getString("payment_method"));
	            }
	        } catch (SQLException e) { e.printStackTrace(); }
	    }
	    
	    // 지점별 차량 목록 조회
	    public static void showCarsByBranch() {
	        String sql = """
	            SELECT b.name AS branch_name, c.model, c.carNum
	            FROM Cars c JOIN Branches b ON c.branchId = b.branchId
	        """;
	        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                System.out.printf("[%s] %s (%s)\n",
	                        rs.getString("branch_name"), rs.getString("model"), rs.getString("carNum"));
	            }
	        } catch (SQLException e) { e.printStackTrace(); }
	    }
	    
	    // 특정 차량의 대여 이력 확인
	    public static void showRentalsByCar(int carId) {
	        String sql = """
	            SELECT c.model, u.email, uc.startdate, uc.enddate, uc.status
	            FROM UsersCars uc
	            JOIN Cars c ON uc.carId = c.carId
	            JOIN Users u ON uc.userId = u.userId
	            WHERE c.carId = ?
	        """;
	        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, carId);
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                System.out.printf("%s | %s | %s ~ %s | %s\n",
	                        rs.getString("model"), rs.getString("email"), rs.getDate("startdate"),
	                        rs.getDate("enddate"), rs.getString("status"));
	            }
	        } catch (SQLException e) { e.printStackTrace(); }
	    }
	    
	    // 차량별 대여 횟수 순위 (TOP 인기 차량 분석)
	    public static void showPopularCars() {
	        String sql = """
	            SELECT c.model, COUNT(*) AS rent_count
	            FROM UsersCars uc
	            JOIN Cars c ON uc.carId = c.carId
	            GROUP BY c.model
	            ORDER BY rent_count DESC
	        """;
	        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                System.out.printf("%s: %d회\n", rs.getString("model"), rs.getInt("rent_count"));
	            }
	        } catch (SQLException e) { e.printStackTrace(); }
	    }
	    
	    // 연령대별 차량 선호도 분석
	    public static void showAgeGroupCarPreference() {
	        String sql = """
	            SELECT FLOOR(u.age / 10) * 10 AS age_group, c.model, COUNT(*) AS count
	            FROM Users u
	            JOIN UsersCars uc ON u.userId = uc.userId
	            JOIN Cars c ON uc.carId = c.carId
	            GROUP BY FLOOR(u.age / 10) * 10, c.model
	            ORDER BY age_group, count DESC
	        """;
	        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                System.out.printf("%d대 | %s: %d회\n", rs.getInt("age_group"), rs.getString("model"), rs.getInt("count"));
	            }
	        } catch (SQLException e) { e.printStackTrace(); }
	    }
	    
	    // 차량별 결제 수단 사용 통계
	    public static void showCarPaymentStats() {
	        String sql = """
	            SELECT c.model, p.name AS payment_method, COUNT(*) AS count
	            FROM UsersCars uc
	            JOIN Cars c ON uc.carId = c.carId
	            JOIN Payments p ON uc.paymentsId = p.paymentsId
	            GROUP BY c.model, p.name
	        """;
	        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                System.out.printf("%s | %s: %d건\n",
	                        rs.getString("model"), rs.getString("payment_method"), rs.getInt("count"));
	            }
	        } catch (SQLException e) { e.printStackTrace(); }
	    }
	}


