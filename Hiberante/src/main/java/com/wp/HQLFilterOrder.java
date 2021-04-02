package com.wp;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HQLFilterOrder {

	public static void main(String[] args) {
		SessionFactory sf = Util.getSF();
		Session session = sf.openSession();
		
		String hql = "SELECT ename,sal FROM Emp WHERE sal>=? ORDER BY sal desc";
		
		Query query = session.createQuery(hql);
		
		query.setParameter(0, 500);
		
		List<Object[]> list = query.getResultList();
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			Object[] object = (Object[]) it.next();
			System.out.println("ename : "+object[0]);
			System.out.println("sal   : "+object[1]);
		}
		session.close();
		
		
	}

}
