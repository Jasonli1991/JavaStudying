package tw.org.iii.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC07 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Keyword = ");
		String key = scanner.next();
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/iii",prop);
			//SELECT * FROM food WHERE name LIKE '%key%' OR address LIKE '%key%' OR tel LIKE '%key%';
			String sql = "SELECT * FROM food WHERE name LIKE ? OR address LIKE ? OR tel LIKE ?";
			String var = "%" + key + "%";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, var);
			pstmt.setString(2, var);
			pstmt.setString(3, var);
			ResultSet result = pstmt.executeQuery();
			
			while (result.next()) {
				String name =result.getString("name");
				String address = result.getString("address");
				String tel =  result.getString("tel");
				System.out.printf("%s:%s:%s\n", name, address, tel);
			}
			
			result.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
