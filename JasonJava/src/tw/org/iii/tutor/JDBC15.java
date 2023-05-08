package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import tw.org.iii.myclasses.Bike;

public class JDBC15 {
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String URL = "jdbc:mysql://localhost:8889/iii";
	private static final String SQL_UPDATE_BIKE = "UPDATE member SET bike = ? WHERE id = ?";

	public static void main(String[] args) {
		
		Bike b1 = new Bike();
		b1.upSpeed(); b1.upSpeed(); b1.upSpeed(); b1.upSpeed();
		System.out.println(b1);
		
		Properties prop = new Properties();
		prop.put("user", USER); prop.put("password", PASSWORD);
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE_BIKE);
			
			pstmt.setObject(1, b1);
			pstmt.setInt(2, 1);
			
			if (pstmt.executeUpdate() > 0) {
				System.out.println("Update2 success");
			}else {
				System.out.println("Update2 failure");
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
