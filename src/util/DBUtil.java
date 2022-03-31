package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;

public class DBUtil {

	private DBUtil() {
		// 드라이버 jar 제대로 인식되는지 체크를 DBUtil 생성자에서 실행하게 한다.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 인식 완료");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 인식 오류");
			e.printStackTrace();
		}
	}

	private static DBUtil instance = new DBUtil();

	public static DBUtil getInstance() {
		return instance;
	}

	///////////////////////////////////////////////////////
	public Connection getConnection() throws SQLException {
		// String url = "\"jdbc:mysql://127.0.0.1:3306/test\"";
		String url = "jdbc:mysql://localhost:3306/happyhouse";
		String username = "ssafy";
		String password = "tmddnjs5Qk";
		return DriverManager.getConnection(url, username, password);
	}

	public void close(AutoCloseable... res) {
		for (AutoCloseable tmp : res) {
			if (tmp != null) {
				try {
					tmp.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	/*
	 * private static DBUtil instance = new DBUtil();
	 * 
	 * private DBUtil() {
	 * 
	 * }
	 * 
	 * public static DBUtil getInstance() { return instance; } public Connection
	 * getConnection() throws SQLException { // tomcat 이 미리 Database에 연결해놨으므로 그 연결을
	 * 가져온다. try { Context context = new InitialContext(); // 탐색기와 같은 기능 -> 메모리에 접근을
	 * 위한 객체 Context rootContext = (Context) context.lookup("java:comp/env"); //
	 * root 를 찾는다. // return type 이 Object 이기때문에 형변환
	 * 
	 * DataSource dataSource = (DataSource) rootContext.lookup("jdbc/ssafy"); return
	 * dataSource.getConnection();
	 * 
	 * } catch (NamingException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return null; }
	 * 
	 * public void close(AutoCloseable... closeables) { for (AutoCloseable c :
	 * closeables) { if (c != null) { try { c.close(); } catch (Exception e) {
	 * e.printStackTrace(); } } } }
	 */
}
