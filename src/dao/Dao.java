package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	static String DB_URL = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	static String DB_USER = "root";
	static String DB_PASSWORD = "qwer1234";
	static Connection conn = null;
	PreparedStatement pstmt = null;;
	ResultSet rs = null;

	String tableName = "";

	Dao() {
		this(null, "");
	}

	Dao(String tableName) {
		this(null, tableName);
	}

	Dao(Connection conn, String tableName) {
//		if (tableName.equals("")) {
//			tableName = "user_info";
//		} else {
//			this.tableName = tableName;
//		}
		this.tableName = tableName;
		
		if (conn == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver"); // 드라이버를 로딩한다 -> ServletContextListener로 처리!
				Dao.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);// 데이터베이스의 연결을 설정한다.
			} catch (Exception e) {
				System.out.println("conn = DriverManager.getConnection..." + e.toString());
			}
		} else {
			Dao.conn = conn;
		}
	}

	void rollback() {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				System.out.println("conn.rollback():" + e.getMessage());
			}
		}
	}

	void close(AutoCloseable... acs) {
		if (acs != null) {
			try {
				for (AutoCloseable ac : acs)
					ac.close();
			} catch (Exception e) {
				System.out.println("ac.close():" + e.toString());
			}
		} else {
			System.out.println("AutoCloseable acss == null");
		}
	}
}