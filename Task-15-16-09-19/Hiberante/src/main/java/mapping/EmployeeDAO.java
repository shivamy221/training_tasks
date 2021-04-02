package mapping;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.wp.Util;

public class EmployeeDAO {

	public static void main(String[] args) {
		
	
		SessionFactory sf = Util.getSF();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("\n@@Enter your Choice@@ \n\n");
		System.out.println("1. Show employees");
		System.out.println("2. Delete Employee");
		System.out.println("3. Update Employee");
		System.out.println("4. Exit");
		
		
		int choice=scanner.nextInt();

		switch(choice)
		{
				case 1: Criteria cr=session.createCriteria(Employee.class);
						List<Employee> emps=cr.list();
						for(Employee emp:emps){
							System.out.println(emp);
						}
		
		
				case 2: System.out.println("\nEnter Employee No to Delete");
						int eno=scanner.nextInt();
						Employee employee=session.get(Employee.class, eno);
			
			
						session.delete(employee);
						System.out.println("\nRecord Deleted");
						transaction.commit();
						break;
		
		
				case 3:	System.out.println("\nEnter Employee No to Update");
						int empno=scanner.nextInt();
						Employee employee2 = session.get(Employee.class, empno);
						employee2.setEname("DDD");
						session.update(employee2);
						System.out.println("\nRecord Updated");
						transaction.commit();
						break;
						
				case 4: System.exit(0);
				
				default:
		}
		
		session.close();
		scanner.close();
	}

}
