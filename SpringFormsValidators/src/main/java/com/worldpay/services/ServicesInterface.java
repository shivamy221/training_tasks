package com.worldpay.services;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.worldpay.model.EmpModel;

public interface ServicesInterface {
	public void addEmp(@ModelAttribute("info") EmpModel Emp);
	public List<EmpModel> viewAllEmployees();
	public EmpModel searchEmp(@ModelAttribute("info") int eno);
	public void removeEmployee(@ModelAttribute("info") int eno);
	public void updateEmp(@ModelAttribute("info") EmpModel emp,String ename,int sal);
}
