package curd_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class drop_table {
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final String Username = "root";
	private static final String Password = "root";
	private static Connection conn;
	private static PreparedStatement pmst;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Database Name :");
	    String URL = "jdbc:mysql://localhost:3306/"+sc.next();
	    
		try {
			Class.forName(Driver);
		    conn = DriverManager.getConnection(URL, Username, Password);
		    System.out.println("Enter Table Name : ");
		    String name = sc.next();
		    String sql = "drop table "+name;
      	    pmst = conn.prepareStatement(sql);
		    int i = pmst.executeUpdate();
		    if(i==0) {
		    	System.out.println(name+"_Table is Droped Successfully !!!");
		    }
		    else {
		    	System.out.println(name+"_Table is Not Droped");
		    }
		    conn.close();
			pmst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
