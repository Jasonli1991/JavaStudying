package tw.org.iii.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC02 {

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/iii", "root", "root");
			
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO cust (cname,tel,birthday) VALUES ('aa', '123', '1999-01-02')";
			
			int count = stmt.executeUpdate(sql);
			System.out.println(count);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
