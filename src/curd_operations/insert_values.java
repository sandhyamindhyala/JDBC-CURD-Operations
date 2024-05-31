package curd_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insert_values {
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
		    String sql = "insert into "+name+"("+name+"_Id,"+name+"_Name,"+name+"_Email) values (?,?,?)";
		    pmst = conn.prepareStatement(sql);
		    System.out.println("Enter "+name+" id");
			pmst.setInt(1, sc.nextInt());
			System.out.println("Enter "+name+" name");
			pmst.setString(2, sc.next());
			System.out.println("Enter "+name+" email");
			pmst.setString(3, sc.next());
		    int i = pmst.executeUpdate();
		    if(i>0) {
		    	System.out.println(name+"_Table values are Inserted Successfully !!!");
		    }
		    else {
		    	System.out.println(name+"_Table values are Not Inserted");
		    }
		    conn.close();
			pmst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
