package task8B;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class CallProcedure {

	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/jdbc";
		
		String user ="root";
		String Password="root";
		
		Connection con = DriverManager.getConnection(url, user, Password);
		
		
		CallableStatement cs=con.prepareCall("{call insert_emp(?,?,?,?,?)}");
		
		System.out.println("Enter employee no.");
		int eno =  scanner.nextInt();
		
		System.out.println("Enter employee name");
		String ename = scanner.next();
		
		System.out.println("Enter salary");
		int sal = scanner.nextInt();
		
		System.out.println("Enter employee desg");
		String desg = scanner.next();
		
		System.out.println("Enter employee dept");
		String dept = scanner.next();
		cs.setInt(1,eno);
		cs.setString(2, ename);
		cs.setInt(3, sal);
		cs.setString(4, desg);
		cs.setString(5, dept);
		cs.execute();
		
		System.out.println("Entry successfull");
	}

}
