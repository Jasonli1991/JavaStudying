package tw.org.iii.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC01 {

	public static void main(String[] args) {
		
		//https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-usagenotes-connect-drivermanager.html
		//1. Load Driver
		//確認buildPath是否有放對地方
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/iii?user=root&password=root");
			System.out.println("OK2");
			
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO cust (cname,tel,birthday) VALUES ('aa', '123', '1999-01-02')";
			//是：查詢結果？否：增、刪、修
			if (stmt.execute(sql)) {
				System.out.println("OK3");
			} else {
				System.out.println("Update");
			}
			
			int count = stmt.executeUpdate(sql);
			System.out.println(count);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
