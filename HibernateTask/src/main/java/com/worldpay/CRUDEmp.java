package com.worldpay;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CRUDEmp {

	public static void main(String args[]) {
		SessionFactory sf=Util.getSF();
		Session session=sf.openSession();
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. View Employee");
			System.out.println("2. Add Employee");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Exit");
			int choice = scanner.nextInt();
			
			switch(choice) {
			
			case 1:
				
				Criteria cr = session.createCriteria(Laptop.class);
				List<Laptop> list = cr.list();
				for(Laptop laptop : list)
				{
					
					System.out.println("Laptop Code : "+laptop.getCode());
					System.out.println("Laptop Brand : "+laptop.getBrand());
					System.out.println("Laptop Price : "+laptop.getPrice());
					System.out.println("Employee No : "+laptop.getEmp().getEno());
					System.out.println("Employee Name : "+laptop.getEmp().getEname());
					System.out.println("Employee Salary : "+laptop.getEmp().getSal());
									
				}
				break;
				
			case 2:
				System.out.println("enter code");
				String code = scanner.next();
				System.out.println("enter brand");
				String brand = scanner.next();
				System.out.println("enter price");
				int price = scanner.nextInt();

				Transaction tr = session.beginTransaction();
				Laptop laptop=new Laptop(code,brand,price);
				session.save(laptop);
				tr.commit();
				break;
				
			case 3:
				System.out.println("enter code");
				String code1 = scanner.next();
				System.out.println("enter brand");
				String brand1 = scanner.next();
				System.out.println("enter price");
				int price1 = scanner.nextInt();
				
				Laptop laptop1=session.get(Laptop.class,code1);
				laptop1.setCode(code1);
				laptop1.setBrand(brand1);
				laptop1.setPrice(price1);
				
				Transaction tr1 = session.beginTransaction();
				session.update(laptop1);
				tr1.commit();
				System.out.println("\nRecord Updated");
				break;
				
			case 4:
				System.out.println("enter code");
				String code2 = scanner.next();
				Laptop laptop2=session.get(Laptop.class,code2);
				Transaction tr2 = session.beginTransaction();
				session.delete(laptop2);
				tr2.commit();
				System.out.println("\nRecord Deleted");
				break;
			
			case 5: System.exit(0);
				
			default:
				System.out.println("Please!!!! Enter correct option ");
			}
		}
	}
}
