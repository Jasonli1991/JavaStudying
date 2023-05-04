package tw.org.iii.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC08 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Page = ");
		int page = scanner.nextInt();
		int rpp = 10;
		int start = (page - 1) * rpp;
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/iii", prop);
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT count(*) total FROM food");
			rs.next();
			int total = rs.getInt("total");
			//int pages = (int) Math.ceil(total *1.0 / rpp);
			int pages = (int) Math.ceil((double) total / rpp);
			
			//自定義Exception
			if(page <= 0 || page > pages) 
				throw new MyPageException("Page ERROR");
				
			
			//分頁效果
			//LIMIT ,"start", "取幾筆"
			String sql = "SELECT * FROM food LIMIT ?, ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, rpp);
			
			
			ResultSet result = pstmt.executeQuery();
			
			while (result.next()) {
				String id = result.getString("id");
				String name = result.getString("name");
				String tel = result.getString("tel");
				System.out.printf("%s:%s:%s\n", id, name, tel);
			}
			
		}catch(MyPageException e) {
			System.out.println("Oops! " + e);
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}

class MyPageException extends Exception {
	private String mesg;
	public MyPageException(String mesg) {
		this.mesg = mesg;
	}
	@Override
	public String toString() {
		return mesg;
	}
}
