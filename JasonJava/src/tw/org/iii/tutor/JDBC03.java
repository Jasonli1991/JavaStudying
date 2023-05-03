package tw.org.iii.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC03 {

	public static void main(String[] args) {
		try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/iii", prop);
			
			Statement stmt = conn.createStatement();
			String sql = "UPDATE cust SET cname='Tony' WHERE id = 4";
			
			int count = stmt.executeUpdate(sql);
			System.out.println(count);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
