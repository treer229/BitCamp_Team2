package kr.or.bit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SingletonHelper {
	private static Connection conn = null;
	private SingletonHelper() {}
	
	public static Connection Conection(String dsn) {
		if(conn != null) {	
			return conn;
		}
		try {
			if(dsn.equals("oracle")) {
			Class.forName("oracle.jdbc.OracleDriver");
			 conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bituser","1004");
			}else if(dsn.equals("mysql")){
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/kostadb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=true",
						"root", "1004");
			}
		} catch (Exception e) {

			System.out.println("E오류 : " +e.getMessage());
		}
		return conn;
	}
	public static Connection getConnection(String dsn , String id , String pwd) {
		if(conn != null) {
			return conn;
		}
		try {
			if(dsn.equals("oracle")) {
			Class.forName("oracle.jdbc.OracleDriver");
			 conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",id,pwd);
			}else if(dsn.equals("mysql")){
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/kostadb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=true",
						id, pwd);
			}
		} catch (Exception e) {
			System.out.println("E2오류 : " +e.getMessage());
		}
		return conn;
	}
	
	public static void Close() {
		if (conn != null)
			try {
				conn.close();
				conn = null;
			} catch (Exception e4) {
				System.out.println("e4에러 : " +e4.getMessage());
			}
	}
	public static void Close(Statement stmt) {
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e3) {
					System.out.println("e3에러 : " +e3.getMessage());
				}
	}
	public static void Close(ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (Exception e2) {
				System.out.println("e2에러 " +e2.getMessage());
			}
	}

	public static void main(String[] args) throws SQLException {
	SingletonHelper s = new SingletonHelper();

	}
	public void korea() {
		System.out.print("request.setCharacterEncoding('UTF-8');");
	}
}
