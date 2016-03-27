package ssm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDriver {
	public static void main(String[] args){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "mingge", "1234");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM tuser");
			while(rs.next()){
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
			}
			}catch(Exception err){
			System.out.println(err.toString());
			}
	}
}
