package tw.org.iii.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC06 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/iii",prop);
			//SELECT * FROM food
			String sql = "SELECT * FROM food";
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			
			//result.next();
			//mySQL存放的型別歸mySQL，取資料時java可自行決定型別
			//System.out.println(result.getString("name")); 
			
			
			while (result.next()) {
				System.out.println(result.getString("name"));
			}
			
			//若沒使用，mySQL其實會自動關閉
			result.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
