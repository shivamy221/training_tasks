package task8A;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;



public class Menu {

		public static Scanner scanner = new Scanner(System.in);

		public static String addEmp() {
			
			System.out.println("Enter employee no.");
			int eno =  scanner.nextInt();
			
			System.out.println("Enter employee name");
			String ename = scanner.next();
			
			System.out.println("Enter salary");
			int sal = scanner.nextInt();
			
			System.out.println("Enter employee desg");
			String desg = scanner.next();
			
			String dept;
			System.out.println("Enter employee dept");
			while(true) {
				dept = scanner.next();
				if(dept.equalsIgnoreCase("it")|dept.equalsIgnoreCase("mkt")|dept.equalsIgnoreCase("acts")|dept.equalsIgnoreCase("hr")) 
					break;
					else
						System.out.println("Enter any one of hr,it,acts,mkt ");
				
			}
			
			String sql = "insert into emp values("+eno+",'"+ename+"',"+sal+",'"+desg+"','"+dept+"')";
			
			return sql;
			
		}

		public static String viewEmployees() {
			
			String sql = "select * from emp";
			
			return sql;
			
		}

		public static String removeEmployees() {
			
			System.out.println("Enter employee no. you want to delete");
			int eno =  scanner.nextInt();
			
			String sql = "delete from emp where emno="+eno;
			
			return sql;
		}

		public static String  cleardata() {
			String sql = "truncate table emp";
			
			return sql;
		}

		public static String changeSalary() {
			
			System.out.println("Enter employee no. whose salary you want to update");
			int eno =  scanner.nextInt();
			
			System.out.println("Enter new salary");
			int sal =  scanner.nextInt();
			
			String sql = "update emp set sal="+sal+" where emno="+eno;
			
			return sql;
		}

		public static String searchemployee() {
			
			System.out.println("Enter employee no. you want to search ");
			int eno =  scanner.nextInt();
			
			String sql = "select * from emp where emno="+eno;
			
			return sql;
			
		}

		public static String viewDeptWise() {
			System.out.println("enter department name");
			String dept = scanner.next();
			
			String sql = "select * from emp where dept='"+dept+"'";
			
			return sql;
		}

		public static void main(String[] args) throws Exception {

			while (true) {
				
				Class.forName("com.mysql.jdbc.Driver");
				
				String url = "jdbc:mysql://localhost:3306/jdbc";
				
				String user ="root";
				String Password="root";
				
				Connection con = DriverManager.getConnection(url, user, Password);			
				
				System.out.println("Enter Number corresponding to operation you wish to perform \n");

				System.out.println("1.Add emp");
				System.out.println("2.View all employees");
				System.out.println("3.Remove employees");
				System.out.println("4.clear data");
				System.out.println("5.change salary");
				System.out.println("6.search employee");
				System.out.println("7.view dept wise list");
				System.out.println("8.exit");
				System.out.println("----------------------------------------------------------------");
				
				int response = scanner.nextInt();
				
				switch (response) {
				
				case 1: 
						String sqlInsert = addEmp();
						Statement stmtInsert = con.createStatement();
						stmtInsert.executeUpdate(sqlInsert);
						System.out.println("Employee Added to DataBase\n");
						break;
					
				case 2: 
						String sqlView = viewEmployees();
						Statement stmtView = con.createStatement();
						ResultSet rs = stmtView.executeQuery(sqlView);
						while(rs.next())
						{
							
							System.out.println(rs.getString(1)+" "+
							rs.getString(2)+" "+
							rs.getString(3)+" "+
							rs.getString(4)+" "+
							rs.getString(5));
						}	
						break;
						
				case 3: 
						String sqlDelete = removeEmployees();
						Statement stmtDelete = con.createStatement();
						stmtDelete.executeUpdate(sqlDelete);
						System.out.println("Employee Deleted from DataBase\n");		
						break;
				case 4:
					String sqlclear = cleardata();
					Statement stmtclear = con.createStatement();
					stmtclear.executeUpdate(sqlclear);
					System.out.println("delete data of emp from DataBase\n");	
					break;
				case 5:
					String sqlSalary = changeSalary();
					Statement stmtSalary = con.createStatement();
					stmtSalary.executeUpdate(sqlSalary);
					System.out.println("delete data of emp from DataBase\n");	
					break;
					
				case 6:
					String sqlSearch = searchemployee();
					Statement stmtSearch  = con.createStatement();
					ResultSet rsearch = stmtSearch .executeQuery(sqlSearch );
					while(rsearch.next())
					{
						
						System.out.println(rsearch.getString(1)+" "+
						rsearch.getString(2)+" "+
						rsearch.getString(3)+" "+
						rsearch.getString(4)+" "+
						rsearch.getString(5));
					}	
					break;
					
				case 7:
					String sqlDeptwise = viewDeptWise();
					Statement stmtDeptwise = con.createStatement();
					ResultSet rswise = stmtDeptwise.executeQuery(sqlDeptwise);
					while(rswise.next())
					{
						
						System.out.println(rswise.getString(1)+" "+
						rswise.getString(2)+" "+
						rswise.getString(3)+" "+
						rswise.getString(4)+" "+
						rswise.getString(5));
					}	
					break;
					
				case 8:
					System.exit(0);

				default:
					System.out.println("Please enter correct option");

				}

			}



	}

}
