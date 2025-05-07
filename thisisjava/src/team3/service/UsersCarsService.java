package team3.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import team3.domain.UsersCars;
import team3.util.DBUtil;

public class UsersCarsService {
	private Connection conn = DBUtil.getConnection();

    public List<UsersCars> getRentList(int userId) {
        List<UsersCars> list = new ArrayList<>();
        String sql = "SELECT * FROM UsersCars WHERE userId = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new UsersCars(
                    rs.getInt("ucno"),
                    rs.getInt("paymentsId"),
                    rs.getInt("carId"),
                    rs.getInt("userId"),
                    rs.getDate("startdate"),
                    rs.getDate("enddate"),
                    rs.getString("price"),
                    rs.getString("status"),
                    rs.getDate("createdAt")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<UsersCars> getJigeumRentList(int userId) {
        List<UsersCars> list = new ArrayList<>();
        String sql = "SELECT * FROM UsersCars WHERE userId = ? AND status != ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setString(2, "반납완료");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new UsersCars(
                    rs.getInt("ucno"),
                    rs.getInt("paymentsId"),
                    rs.getInt("carId"),
                    rs.getInt("userId"),
                    rs.getDate("startdate"),
                    rs.getDate("enddate"),
                    rs.getString("price"),
                    rs.getString("status"),
                    rs.getDate("createdAt")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

 //  차량 예약 가능 여부 체크 (기간 겹침 확인)
    public boolean isCarAvailable(int carId, Date newStartDate, Date newEndDate) {
        String sql = """
            SELECT COUNT(*)
            FROM UsersCars
            WHERE carId = ?
            AND status != '반납완료'
            AND (
                startdate <= ? AND enddate >= ?
            )
        """;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, carId);
            pstmt.setDate(2, newEndDate);
            pstmt.setDate(3, newStartDate);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) == 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //  차량 대여 - 예약 가능 여부 선체크 포함
    public void rentCar(Scanner scanner, int userId) {
        try {
            // 1. 사용자로부터 대여 날짜 입력 받기
            System.out.print("대여 시작일(YYYY-MM-DD): ");
            Date start = Date.valueOf(scanner.nextLine());
            System.out.print("대여 종료일(YYYY-MM-DD): ");
            Date end = Date.valueOf(scanner.nextLine());
            System.out.println();

            // 2. 해당 날짜 사이에 이용 가능한 차량 목록 조회
            List<String> availableCars = new CarsService().getAvailableCarsByDateRange(start, end);

            if (availableCars.isEmpty()) {
                System.out.println("❌ 해당 기간 동안 예약 가능한 차량이 없습니다.");
                return;
            }

            System.out.println("[해당 기간 예약 가능한 차량 목록]");
            availableCars.forEach(System.out::println);
            System.out.println();

            // 3. 차량 선택 및 결제 수단 입력
            System.out.print("차량 ID: ");
            int carId = Integer.parseInt(scanner.nextLine());
            System.out.print("결제 방식 ID: ");
            int paymentId = Integer.parseInt(scanner.nextLine());
            System.out.println();

            // 4. 요금 계산: 하루 2만원 × 날짜 수 (시작일 포함)
            long days = (end.getTime() - start.getTime()) / (1000 * 60 * 60 * 24) + 1;
            String price = String.valueOf(days * 20000);
            System.out.println("📢 총 요금: " + price + "원 (" + days + "일 × 20,000원)");

            // 5. 다시 한 번 중복 예약 체크 (예외 상황 대비)
            if (!isCarAvailable(carId, start, end)) {
                System.out.println("❌ 해당 차량은 이미 예약되어 있습니다.");
                return;
            }

            // 6. 대여 등록
            String sql = """
                INSERT INTO UsersCars
                (ucno, paymentsId, carId, userId, startdate, enddate, price, status, createdAt)
                VALUES (?, ?, ?, ?, ?, ?, ?, '예약완료', SYSDATE)
            """;

            int ucno = generateUcno();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ucno);
            pstmt.setInt(2, paymentId);
            pstmt.setInt(3, carId);
            pstmt.setInt(4, userId);
            pstmt.setDate(5, start);
            pstmt.setDate(6, end);
            pstmt.setString(7, price);

            int rows = pstmt.executeUpdate();
            System.out.println(rows > 0 ? "✅ 대여 완료" : "❌ 대여 실패");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void returnCar(Scanner scanner, int userId) {
        System.out.print("반납할 ucno 입력: ");
        int ucno = Integer.parseInt(scanner.nextLine());

        LocalDate today = LocalDate.now();
        LocalDate endDate = null;

        // 반납 예정일 먼저 조회
        String selectSql = """
            SELECT enddate
            FROM UsersCars
            WHERE ucno = ? AND userid = ? AND status IN ('예약완료', '대여중')
        """;

        try (PreparedStatement pstmt = conn.prepareStatement(selectSql)) {
            pstmt.setInt(1, ucno);
            pstmt.setInt(2, userId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                endDate = rs.getDate("enddate").toLocalDate();
            } else {
                System.out.println("❌ 반납할 차량이 존재하지 않거나 이미 반납되었습니다.");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        // 반납 처리 (상태 → 반납완료, 반납일 현재 날짜로 갱신)
        String updateSql = """
            UPDATE UsersCars
            SET enddate = ?, status = '반납완료'
            WHERE ucno = ? AND userid = ? AND status IN ('예약완료', '대여중')
        """;

        try (PreparedStatement pstmt = conn.prepareStatement(updateSql)) {
            pstmt.setDate(1, Date.valueOf(today));
            pstmt.setInt(2, ucno);
            pstmt.setInt(3, userId);
            int rows = pstmt.executeUpdate();
            System.out.println(rows > 0 ? "✅ 반납 완료" : "❌ 반납 실패");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 연체 감점 처리 (하루당 5점, 최소 0점 유지)
        if (endDate != null && today.isAfter(endDate)) {
            long daysLate = ChronoUnit.DAYS.between(endDate, today);
            int penalty = (int) (daysLate * 5);

            String scoreSql = "UPDATE Users SET score = GREATEST(score - ?, 0) WHERE userid = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(scoreSql)) {
                pstmt.setInt(1, penalty);
                pstmt.setInt(2, userId);
                pstmt.executeUpdate();
                System.out.printf("⚠️ 연체 %d일 → %d점 차감되었습니다.%n", daysLate, penalty);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void cancelRent(Scanner scanner, int userId) {
        System.out.print("취소할 ucno 입력: ");
        int ucno = Integer.parseInt(scanner.nextLine());
        String sql = "DELETE FROM UsersCars WHERE ucno = ? AND userId = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ucno);
            pstmt.setInt(2, userId);
            int rows = pstmt.executeUpdate();
            System.out.println(rows > 0 ? "취소 완료" : "취소 실패");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int generateUcno() {
        String sql = "SELECT NVL(MAX(ucno), 0) + 1 FROM UsersCars";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

}