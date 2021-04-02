package task4;

import java.util.*;

public class Menu {

	public static ArrayList<Employees> list = new ArrayList<>();
	public static Scanner scn = new Scanner(System.in);

	public static void addEmp() {
		System.out.println("enter the value of these required fields");
		System.out.println("Enter employee no. : ");
		long empno = scn.nextLong();
		System.out.println("Enter employee name");
		String ename = scn.next();
		System.out.println("Enter employee salary");
		int salary = scn.nextInt();
		System.out.println("Enter employee designation");
		String designation = scn.next();
		System.out.println("Enter employee dept");
		String dept = scn.next();

		Employees emp = new Employees(empno, ename, salary, designation, dept);
		list.add(emp);
	}

	public static void viewEmployees() {
		Iterator<Employees> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public static void removeEmployees() {
		System.out.println("Enter Employee number whom you wish to remove");
		int eno = scn.nextInt();
		for (int j = 0; j < list.size(); j++) {
			if (list.get(j).getEno() == eno) {
				list.remove(j);
			}

		}
		
	}

	public static void cleardata() {
		System.out.println("Cleared all data");
		list.clear();
	}

	public static void changeSalary() {
		System.out.println("Enter Employee no. whose salary to change ");
		int em = scn.nextInt();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getEno() == em) {
				list.get(i).setSalary(scn.nextInt());
			}

		}
	}

	public static void searchemployee() {
		System.out.println("Enter empno for searching ");
		int eno = scn.nextInt();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getEno() == eno)
				System.out.println(list.get(i).toString());
		}
	}

	public static void viewDeptWise() {
		System.out.println("Enter name of department ");
		String dept = scn.next();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getDepartment().equals(dept.toString()))
				System.out.println(list.get(i).toString());
		}
	}

	public static void main(String[] args) {

		while (true) {
			
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
			int response = scn.nextInt();
			switch (response) {
			case 1:
				addEmp();
				break;
			case 2:
				viewEmployees();
				break;
			case 3:
				removeEmployees();
				break;
			case 4:
				cleardata();
				break;
			case 5:
				changeSalary();
				break;
			case 6:
				searchemployee();
				break;
			case 7:
				viewDeptWise();
				break;
			case 8:
				System.exit(0);

			default:
				System.out.println("Please enter correct option");

			}

		}

	}

}
