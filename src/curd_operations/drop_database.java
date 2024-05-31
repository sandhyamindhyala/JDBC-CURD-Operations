package curd_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class drop_database {
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final String Username = "root";
	private static final String Password = "root";
	private static Connection conn;
	private static PreparedStatement pmst;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Database Name :");
	    String URL = "jdbc:mysql://localhost:3306/";
	    
		try {
			Class.forName(Driver);
		    conn = DriverManager.getConnection(URL, Username, Password);
		    String sql = "drop database "+sc.next();
		    pmst = conn.prepareStatement(sql);
		    int i = pmst.executeUpdate();
		    if(i==0) {
		    	System.out.println("Database is droped Successfully !!!");
		    }
		    else {
		    	System.out.println("Database is Not droped");
		    }
		    conn.close();
			pmst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
