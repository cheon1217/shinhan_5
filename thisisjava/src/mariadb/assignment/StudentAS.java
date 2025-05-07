package mariadb.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentAS {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			conn = DriverManager.getConnection(
				"jdbc:mariadb://127.0.0.1:3306/study", "testuser", "test1234"
			);
			
			String sql = "" + "SELECT s.name, s.tel, m.name AS major_name, p.name AS prof_name " + 
						 "FROM student s " + "LEFT JOIN major m ON s.major1 = m.code " + "LEFT JOIN professor p ON s.profno = p.no";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            // 4. 결과 출력
            System.out.println("이름\t\t연락처\t\t전공\t\t교수");
            System.out.println("------------------------------------------------------------");

            while (rs.next()) {
                String name = rs.getString("name");
                String tel = rs.getString("tel");
                String major = rs.getString("major_name");
                String professor = rs.getString("prof_name");

                System.out.printf("%-8s\t%-13s\t%-10s\t%-10s\n",
                        name, tel, major != null ? major : "없음", professor != null ? professor : "없음");
            }

            rs.close();
            pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

}
