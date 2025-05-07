package ch20.oracle.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521/xe", "testuser", "test1234"
			);
			
			String val1 = "";
			String val2 = "";
			
			String sql = "insert into user (aaa, bbb) values ('" + val1 + "', '" + val2 + "')"; // statement
			
			String sql2 = "insert into user (aaa, bbb) values (?, ?)";  // preparedStatement
			
			System.out.println("연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
					System.out.println("연결 끊기");
				} catch (SQLException e) {}
			}
		}
	}

}
