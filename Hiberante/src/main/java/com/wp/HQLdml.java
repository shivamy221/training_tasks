package com.wp;

import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HQLdml {

	public static void main(String[] args) {
		
		SessionFactory sf = Util.getSF();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Scanner scanner = new Scanner(System.in);

		String hql = "UPDATE Emp SET sal=:sal WHERE empno=:no";
		System.out.println("Enter empno whose name to change");
		int no = scanner.nextInt();
		System.out.println("Enter new Salary of employee");
		int sal = scanner.nextInt();
		
		Query query = session.createQuery(hql);
		query.setParameter("no", no);
		query.setParameter("sal", sal);
		
		query.executeUpdate();
		transaction.commit();
		
		System.out.println("Updation Successful");

		session.close();
		scanner.close();
		
	}

}
