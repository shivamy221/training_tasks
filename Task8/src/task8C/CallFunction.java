package task8C;

import java.sql.*;
import java.util.Scanner;


public class CallFunction {

public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/jdbc";
		
		String user ="root";
		String Password="root";
		
		Connection con = DriverManager.getConnection(url, user, Password);
		
		
		CallableStatement cs=con.prepareCall("{?=call delete_emp(?)}");
		
		System.out.println("Enter employee no. you want to delete");
		int eno =  scanner.nextInt();
				
		cs.setInt(2,eno);
		cs.execute();
		cs.getInt(1);
		
		System.out.println("Deletion successfull");
	}


}
