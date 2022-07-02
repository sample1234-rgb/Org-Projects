package main.Database;

import java.sql.*;

public class DataBase {
	final static String DB_URL= "jdbc:mysql://localhost:3306/bank?";
	final static String USER="root";
	final static String PASSWORD = "GauravX2411";
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			// connection
			Connection conn =  DriverManager.getConnection(DB_URL, USER,PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
			while(rs.next()){
				System.out.println(rs.getString("name"));
			}
			System.out.println("established");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
