package com.worldpay;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CRUDProject {

	public static void main(String[] args) {
		SessionFactory sf=Util.getSF();
		Session session=sf.openSession();
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. View project");
			System.out.println("2. Add project");
			System.out.println("3. Update project");
			System.out.println("4. Delete project");
			System.out.println("5. Exit");
			int choice = scanner.nextInt();
			
			switch(choice) {
			case 1:
			
			Criteria cr = session.createCriteria(Project.class);
			List<Project> list = cr.list();
			for(Project project : list)
			{
				
				System.out.println("Project code : "+project.getPcode());
				System.out.println("Project Title : "+project.getPtitle());
				System.out.println("Project Cost : "+project.getCost());
				
				List<Emp> emp=project.getEmployees();
				for(Emp employee:emp){
					System.out.println(employee.getEno()+","+employee.getEname()+","+employee.getSal());
				
				}
				
				
				
			}
			break;
			
			case 2:
			System.out.println("enter pcode");
			String pcode = scanner.next();
			System.out.println("enter ptitle");
			String ptitle = scanner.next();
			System.out.println("enter cost");
			int price = scanner.nextInt();

			Transaction tr = session.beginTransaction();
			Project project=new Project(pcode,ptitle,price);
			session.save(project);
			tr.commit();
			break;
			
		case 3:
			System.out.println("enter pcode");
			String pcode1 = scanner.next();
			System.out.println("enter ptitle");
			String ptitle1 = scanner.next();
			System.out.println("enter cost");
			int price1 = scanner.nextInt();
			
			
			Project project1=session.get(Project.class,pcode1);
			project1.setPcode(pcode1);
			project1.setPtitle(ptitle1);
			project1.setCost(price1);
			
			Transaction tr1 = session.beginTransaction();
			session.update(project1);
			tr1.commit();
			System.out.println("\nRecord Updated");
			break;
			
		case 4:
			System.out.println("enter pcode");
			String pcode2 = scanner.next();
			Project project2=session.get(Project.class,pcode2);
			Transaction tr2 = session.beginTransaction();
			session.delete(project2);
			tr2.commit();
			System.out.println("\nRecord Deleted");
			break;
			
		case 5:
			System.exit(0);
			
		default:
			System.out.println("please!!! Enter Correct Option");
		}
	}

	}

}
