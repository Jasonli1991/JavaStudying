package tw.org.iii.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.json.JSONStringer;
import org.json.JSONWriter;

public class JDBC12 {
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String URL = "jdbc:mysql://localhost:8889/Jason";

	public static void main(String[] args) {
		String sql = 
			"select e.FirstName, e.LastName, sum(od.UnitPrice * od.Quantity) sum "
			+ "from orders o "
			+ "join employees e on (o.EmployeeID = e.EmployeeID) "
			+ "join orderdetails od on (o.OrderID = od.OrderID) "
			+ "GROUP by e.FirstName, e.LastName "
			+ "ORDER by sum desc";
		
		Properties prop = new Properties();
		prop.put("user", USER); prop.put("password", PASSWORD);
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			//test
			//while (rs.next()) {
				//System.out.println(rs.getString("Firstname") + ":" + rs.getString("sum"));
			//}
			
			JSONStringer js = new JSONStringer();
			JSONWriter jw = js.array();
			int rank = 1;
			while (rs.next()) {
				String firstName = rs.getString("Firstname");
				String lastName = rs.getString("Lastname");
				double sum = rs.getDouble("sum");
				
				jw.object();
				jw.key("rank").value(rank++);
				jw.key("firstname").value(firstName);
				jw.key("lastname").value(lastName);
				jw.key("sum").value(sum);
				jw.endObject();
				
			}
			
			jw.endArray();
			
			System.out.println(jw.toString());
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		

		
		
	}

}