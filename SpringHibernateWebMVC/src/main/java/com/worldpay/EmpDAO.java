package com.worldpay;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmpDAO {
	
	public List<EmpModel> viewAll(){
		
		SessionFactory sf = Util.getSF();
		Session session = sf.openSession();
		@SuppressWarnings("Depricated")
		Criteria cr = session.createCriteria(EmpModel.class);
		List<EmpModel> EmpList = cr.list();
		return EmpList;	
	}
	
	public void insertEmp(EmpModel emp) {
		SessionFactory sf = Util.getSF();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
	
		session.save(emp);
		
		tr.commit();
		session.close();
	}
	
	public EmpModel empSearch(int eno) {
		SessionFactory sf=Util.getSF();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		EmpModel emp = (EmpModel)session.get(EmpModel.class,eno);
		return emp;		
	}
	
	public void deleteEmp(int eno) {
		SessionFactory sf = Util.getSF();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		EmpModel emp = (EmpModel)session.get(EmpModel.class,eno);
		session.delete(emp);
		
		tr.commit();
		session.close();
	}

	public void updateEmp(EmpModel emp,String ename,int sal) {
		SessionFactory sf = Util.getSF();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		emp.setEname(ename);
		emp.setSal(sal);
		
		session.update(emp);
		tr.commit();
		session.close(); 
	}
}
