package com.worldpay;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CRUDVehicle {

	public static void main(String[] args) {
		SessionFactory sf=Util.getSF();
		Session session=sf.openSession();
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. View Vehicle");
			System.out.println("2. Add Vehicle");
			System.out.println("3. Update Vehicle");
			System.out.println("4. Delete Vehicle");
			System.out.println("5. Exit");
			int choice = scanner.nextInt();
			
			switch(choice) {
			case 1:
				Criteria cr = session.createCriteria(Vehicle.class);
				List<Vehicle> list = cr.list();
				for(Vehicle vehicle : list)
				{
					
					System.out.println("Vehicle RegNo : "+vehicle.getRegno());
					System.out.println("Vehicle Brand : "+vehicle.getBrand());
					System.out.println("Vehicle Model : "+vehicle.getModel());
					System.out.println("Vehicle Price : "+vehicle.getPrice());
					System.out.println("Employee No : "+vehicle.getEmp().getEno());
					System.out.println("Employee Name : "+vehicle.getEmp().getEname());
					System.out.println("Employee Salary : "+vehicle.getEmp().getSal());
					System.out.println("..........................");
					
					
				}
				break;
				
			case 2:
				System.out.println("enter regNo");
				String regNo = scanner.next();
				System.out.println("enter brand");
				String brand = scanner.next();
				System.out.println("enter model");
				String model = scanner.next();
				System.out.println("enter price");
				int price = scanner.nextInt();
				System.out.println("enter eno");
				int eno = scanner.nextInt();

				Transaction tr = session.beginTransaction();
				Vehicle vehicle=new Vehicle(regNo,brand,model,price,new Emp(eno));
				session.save(vehicle);
				tr.commit();
				break;
				
			case 3:
				System.out.println("enter regNo");
				String regNo1 = scanner.next();
				System.out.println("enter brand");
				String brand1 = scanner.next();
				System.out.println("enter model");
				String model1 = scanner.next();
				System.out.println("enter price");
				int price1 = scanner.nextInt();
				System.out.println("enter eno");
				int eno1 = scanner.nextInt();
				
				
				Vehicle vehicle1=session.get(Vehicle.class,regNo1);
				vehicle1.setRegno(regNo1);
				vehicle1.setBrand(brand1);
				vehicle1.setModel(model1);
				vehicle1.setPrice(price1);
				vehicle1.setEmp(new Emp(eno1));
				
				Transaction tr1 = session.beginTransaction();
				session.update(vehicle1);
				tr1.commit();
				System.out.println("\nRecord Updated");
				break;
				
			case 4:
				System.out.println("enter regNo");
				String regNo2 = scanner.next();
				Vehicle vehicle2=session.get(Vehicle.class,regNo2);
				Transaction tr2 = session.beginTransaction();
				session.delete(vehicle2);
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
