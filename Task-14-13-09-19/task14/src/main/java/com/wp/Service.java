package com.wp;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Service {

	static Scanner scanner = new Scanner(System.in);
	
	static Configuration config = new Configuration().configure();
	static SessionFactory sf= config.buildSessionFactory();
	
	public static void saveEmployee() {
		
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		System.out.println("Enter employee no : ");
		int empno = scanner.nextInt();
		System.out.println("Enter employee name : ");
		String ename = scanner.next();
		System.out.println("Enter employee salary : ");
		int sal = scanner.nextInt();
	
		Emp emp = new Emp(empno,ename,sal);
		session.save(emp);
		t.commit();
		
		session.close();
		System.out.println("Successfully inserted "+emp);
	}
	
	public static void deleteEmployee() {
		
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		System.out.println("Enter employee no of employee you want to delete : ");
		int empno = scanner.nextInt();
		Emp emp = session.get(Emp.class, empno);
		if(emp!=null){
			session.delete(emp);
            System.out.println("Deleted Successfully");
         }
		else {
			System.out.println("Invalid Employee no.");
		}
		t.commit();
		session.close();
	}
	
	public static void updateEmployee() {
		
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		Emp emp = new Emp();
		System.out.println("Enter employee no");
		emp.setEmpno(scanner.nextInt());
		System.out.println("Enter employee name");
		emp.setEname(scanner.next());
		System.out.println("Enter employee salary");
		emp.setSal(scanner.nextInt());
		
		session.update(emp);
		t.commit();
		
		System.out.println("Employee Details Updated");
		 
	}
	public static void main(String[] args) {
		
		while(true) {
			int choice=0;
			System.out.println("\n@@  Enter option  @@\n");
			System.out.println("1. Add employee");
			System.out.println("2. Delete employee");
			System.out.println("3. Update employee");
			System.out.println("4. Exit");
			
			try {
				choice=scanner.nextInt();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			switch(choice) {
			case 1: saveEmployee();
					break;
					
			case 2: deleteEmployee();
					break;
					
			case 3: updateEmployee();
					break;
					
			case 4: System.exit(0);
			
			default:
			}
			
		}		

	}

}
