
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Login {
	final static String DB_URL= "jdbc:mysql://localhost:3306/bank?";
	final static String USER="root";
	final static String PASSWORD = "GauravX2411";
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn =  DriverManager.getConnection(DB_URL, USER,PASSWORD);
			
			System.out.println("Connected");
			Statement stmt = conn.createStatement();
			
			Scanner sc = new Scanner(System.in);
			Long CardNo = Long.parseLong("1234567890123456");
			System.out.println("Enter PIN");
			int pin = sc.nextInt();
			ResultSet rs = stmt.executeQuery("SELECT * from DebitCards where Card_no="+CardNo + " and pin=" + pin);
			
//			ResultSet rs = stmt.executeQuery("SELECT * FROM users");
			while(rs.next()){
				System.out.println("Status: " + rs.getString("status"));
			}
			sc.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void login() {
		Scanner sc = new Scanner(System.in);
		Long CardNo = Long.parseLong("1234567890123456");
		System.out.println("Enter PIN");
		int pin = sc.nextInt();
		stmt.executeQuery("SELECT * from DebitCards where Card_no="+CardNo + " and pin=" + pin);
		
	} 

}
