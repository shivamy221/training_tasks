package task7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.Scanner;

public class BasciCodeJDBC {

	static Scanner scanner = new Scanner(System.in);
	
	public static String insertion() {
		System.out.println("Enter employee no.");
		int eno =  scanner.nextInt();
		System.out.println("Enter employee name");
		String ename = scanner.next();
		System.out.println("Enter salary");
		int sal = scanner.nextInt();
		
		String sql = "insert into emp values("+eno+",'"+ename+"',"+sal+")";
		
		return sql;
	}
	
	public static String updation() {
		System.out.println("Enter emp no to change ");
		int updateEmp = scanner.nextInt();
		System.out.println("Enter new name of emp");
		String newName = scanner.next();
		
		String sql = "update emp set ename='"+newName+"' where emno="+updateEmp+";";
		
		return sql;
	}
	
	public static String deletion() {
		System.out.println("Enter emp no to delete ");
		int delete = scanner.nextInt();
		
		String sql="delete emp where emno="+delete+";";
		
		return sql;
	}
	
	public static String tableCreation() {
		System.out.println("Enter table name");
		String tableName = scanner.next();
		System.out.println("Enter primary key column name of type int ");
		String pk= scanner.next();
		System.out.println("Enter name of second  column of type varchar");
		String second = scanner.next();
		System.out.println("Enter name of third  column of type varchar");
		String third = scanner.next();
		
		String sql="create table "+tableName+" ("+pk+" int primary key,"+second+" varchar(20),"+third+" varchar(20));";
		/*create table test(pk int primary key,second varchar(20),third varchar(20));*/
		return sql;
	}
	
	public static String tableAlteration() {
		System.out.println("enter table name whose column you want to modify");
		String tableName=scanner.next();
		System.out.println("enter name of column which you want renamed");
		String columnName=scanner.next();
		System.out.println("enter new name of column");
		String newName=scanner.next();
		
		String sql = "alter table "+tableName+" change "+columnName+" "+newName+" varchar(20);";
		
		return sql;
	}
	
	
	
	public static void main(String[] args) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded Successfull");
			String url = "jdbc:mysql://localhost:3306/jdbc";
			
			String user ="root";
			String Password="root";
			
			Connection con = DriverManager.getConnection(url, user, Password);
			
			/*String sql = "insert into emp values(111,'aaa',50000)";
			Statement stmt = con.createStatement();
			int n = stmt.executeUpdate(sql);*/
			
			while(true) {
				int response=0;
				
				System.out.println("Enter Operation you wish to perform");
				System.out.println("1.Insertion");
				System.out.println("2.Updation");
				System.out.println("3.Deletion");
				System.out.println("4.TableCreation");
				System.out.println("5.TableAlteration");
				
				response= scanner.nextInt();
				
				switch(response) {
				
				case 1: String sqlInsert = insertion();
						Statement stmtInsert = con.createStatement();
						stmtInsert.executeUpdate(sqlInsert);
						System.out.println("Row inserted\n");
						
				case 2: String sqlUpdation = updation();
						Statement stmtUpdate = con.createStatement();
						stmtUpdate.executeUpdate(sqlUpdation);
						System.out.println("Row Updated\n");
						
				case 3: String sqlDelete = deletion();
						Statement stmtDelete = con.createStatement();
						stmtDelete.executeUpdate(sqlDelete);
						System.out.println("Row Deleted\n");
				
				case 4: String sqlTableCreation = tableCreation();
						Statement stmtCreate = con.createStatement();
						stmtCreate.executeUpdate(sqlTableCreation);
						System.out.println("table Created\n");
				
				case 5: String sqlAlteration = tableAlteration();
						/*System.out.println(sqlAlteration);*/
						Statement stmtAlter = con.createStatement();
						stmtAlter.executeUpdate(sqlAlteration);
						System.out.println("table Altered\n");
						
				}
				
			}
			
			
		}
		catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		catch(SQLException eq) {
			eq.printStackTrace();
		}
	}

}
