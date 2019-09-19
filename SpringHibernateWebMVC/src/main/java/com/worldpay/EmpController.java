package com.worldpay;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	
	@RequestMapping("InsertPage")
	public ModelAndView insertPage() {
		ModelAndView mv=new ModelAndView("InsertPage.jsp");
		return mv;
	}
	
	@RequestMapping("EmpSearch")
	public ModelAndView EmpSeach() {
		ModelAndView mv=new ModelAndView("EmpSearch.jsp");
		return mv;
	}
	
	@RequestMapping("Delete") 
	public ModelAndView deletePage(){
		ModelAndView mv = new ModelAndView("DeletePage.jsp");
		return mv;
	}
	
	@RequestMapping("Update")
	public ModelAndView Update() {
		ModelAndView mv = new ModelAndView("UpdatePage.jsp");
		return mv;
	}
	
	@RequestMapping("AddEmp")
	public ModelAndView insertEmp(@ModelAttribute("info") EmpModel emp) {
		
		EmpDAO DAO = new EmpDAO();
		DAO.insertEmp(emp);
		ModelAndView mv = new 	ModelAndView("AddSuccess.jsp");
		return mv;
	}
	
	@RequestMapping("RetriveAll")
	public ModelAndView retriveAll() {

		EmpDAO DAO = new EmpDAO();
		List<EmpModel> EmpList = DAO.viewAll();
		ModelAndView mv = new ModelAndView("AllEmp.jsp");
		mv.addObject("EmpList", EmpList);
		return mv;
	}
	
	@RequestMapping("empSearch")
	public ModelAndView empSearch(int eno){
		
		EmpDAO DAO = new EmpDAO();
		EmpModel emp = DAO.empSearch(eno);
		ModelAndView mv = new ModelAndView("searchResult.jsp");
		mv.addObject("emp", emp);
		return mv;
		
	}
	
	@RequestMapping("deleteEmp")
	public ModelAndView deleteEmp(int eno) {
	
		EmpDAO DAO = new EmpDAO();
		EmpModel emp = DAO.empSearch(eno);
		DAO.deleteEmp(eno);
		ModelAndView mv = new ModelAndView("deleteResult.jsp");
		mv.addObject("emp", emp);
		return mv;
	}
	
	@RequestMapping("updateEmp")
	public ModelAndView updateEmp(int eno,String ename,int sal) {
		EmpDAO DAO = new EmpDAO();
		EmpModel emp = DAO.empSearch(eno);
		DAO.updateEmp(emp, ename, sal);
		ModelAndView mv = new ModelAndView("updateResult.jsp");
		mv.addObject("emp", emp);
		return mv;
	}
}
