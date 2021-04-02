package com.wp;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SQLRetrieve {

	public static void main(String[] args) {
		SessionFactory sf = Util.getSF();
		Session session = sf.openSession();
		
		String sql = "SELECT * FROM emp";
		SQLQuery query = session.createSQLQuery(sql);
		
		query.addEntity(Emp.class);
		
		List<Emp> vlist = query.list();
		
		for(Emp emp : vlist)
			System.out.println(emp);
		
		
	}

}
