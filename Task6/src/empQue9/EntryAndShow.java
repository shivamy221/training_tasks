package empQue9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class EntryAndShow {

	public static void main(String[] args) throws Exception {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("To Add Employee - Press 1");
		System.out.println("To show employee - Press 2");
		
		Employee e;
		int check=sc.nextInt();
		if(check==1)
		{
			
			System.out.println("Enter Employee No: ");
			int eNum=sc.nextInt();
			
			System.out.println("Enter Employee Name: ");
			String eName=sc.next();
			
			System.out.println("Enter Employee Salary: ");
			int eSal=sc.nextInt();
			
			System.out.println("Enter Employee desg: ");
			String edesg=sc.next();
			
			System.out.println("Enter Employee dept: ");
			String edept=sc.next();
			
			
			e=new Employee(eNum,eName,eSal,edesg,edept);
			
			File f=new File("E:/data/emp.txt");
			FileOutputStream fos=new FileOutputStream(f);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(e);
			
			fos.close();
			oos.close();
			
			System.out.println("Employee Details Saved");
		}
		else if(check==2)
		{
			
			File f=new File("E:/data/emp.txt");
			FileInputStream fis=new FileInputStream(f);
			ObjectInputStream ois=new ObjectInputStream(fis);
			e = (Employee) ois.readObject();
			
			System.out.println("Employee No "+e.eno);
			System.out.println("Employee Name "+e.ename);
			System.out.println("Employe Salary "+e.sal);
			System.out.println("Employe Salary "+e.desg);
			System.out.println("Employe Salary "+e.dept);
			
			fis.close();
			ois.close();
		}
		
		else
			System.exit(0);
		
		sc.close();
	
}


}
