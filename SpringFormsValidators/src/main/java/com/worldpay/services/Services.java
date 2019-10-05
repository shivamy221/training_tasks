package com.worldpay.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.worldpay.DAO.EmpDAOInterface;
import com.worldpay.model.EmpModel;

@Service
public class Services implements ServicesInterface{

	@Autowired
	private EmpDAOInterface DAO;
	
	public void addEmp(EmpModel Emp) {
		DAO.insertEmp(Emp);
	}
	
	public List<EmpModel> viewAllEmployees()
	{
		List<EmpModel> empList=DAO.viewAll();
		return empList;
		
	}
	
	public EmpModel searchEmp(int eno)
	{
		EmpModel e=DAO.empSearch(eno);
		return e;
		
	}
	
	public void removeEmployee(int eno)
	{
		DAO.deleteEmp(eno);
	}
	
	public void updateEmp(EmpModel emp,String ename,int sal)
	{
		DAO.updateEmp(emp, ename, sal);
	}
}
