package com.wp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

public class RetriveQBCandOrdering {

	public static void main(String[] args) {
		SessionFactory sf=Util.getSF();
		Session session=sf.openSession();
		
		Criteria cr = session.createCriteria(Emp.class);
		
		Order order = Order.asc("sal");
		cr.addOrder(order);
		
		List<Emp> emps = cr.list();
		for(Emp emp : emps)
			System.out.println(emp);
		
		session.close();
	}

}
