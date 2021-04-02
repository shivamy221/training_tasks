package com.wp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class QBCFilterationAndProjection {

	public static void main(String[] args) {
		SessionFactory sf = Util.getSF();
		Session session=sf.openSession();
		
		Criteria cr = session.createCriteria(Emp.class);
		
		Criterion crn = Restrictions.between("sal", 500, 2000);
		
		ProjectionList pList = Projections.projectionList();
		
		Projection p1 = Projections.property("ename");
		Projection p2 = Projections.property("sal");
		
		pList.add(p1);
		pList.add(p2);
		cr.add(crn);
		
		
		cr.setProjection(pList);
		
		List<Object []> emps = cr.list();
		
		for(Object objects[]:emps) 
			for(Object object:objects)
				System.out.println(object);
		
	}

}
