package curd_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class delete_values {
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
		    String sql = "delete from "+name+" where "+name+"_Id = ?";
		    pmst = conn.prepareStatement(sql);
		    System.out.println("Enter "+name+" id");
			pmst.setInt(1, sc.nextInt());
			
		    int i = pmst.executeUpdate();
		    if(i>0) {
		    	System.out.println(name+"_Table values are Deleted Successfully !!!");
		    }
		    else {
		    	System.out.println(name+"_Table values are Not Deleted");
		    }
		    conn.close();
			pmst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
