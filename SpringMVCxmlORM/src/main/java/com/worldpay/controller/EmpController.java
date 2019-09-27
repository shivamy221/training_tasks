package com.worldpay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.worldpay.model.EmpModel;
import com.worldpay.services.ServicesInterface;

@Controller
public class EmpController {
	
	@Autowired
	private ServicesInterface services;
	
	@RequestMapping("InsertPage")
	public ModelAndView insertPage() {
		ModelAndView mv=new ModelAndView("InsertPage");
		return mv;
	}
	
	@RequestMapping("EmpSearch")
	public ModelAndView EmpSeach() {
		ModelAndView mv=new ModelAndView("EmpSearch");
		return mv;
	}
	
	@RequestMapping("Delete") 
	public ModelAndView deletePage(){
		ModelAndView mv = new ModelAndView("DeletePage");
		return mv;
	}
	
	@RequestMapping("Update")
	public ModelAndView Update() {
		ModelAndView mv = new ModelAndView("UpdatePage");
		return mv;
	}
	
	@RequestMapping("AddEmp")
	public ModelAndView insertEmp(@ModelAttribute("info") EmpModel emp) {
		
		services.addEmp(emp);
		ModelAndView mv = new 	ModelAndView("AddSuccess");
		return mv;
	}
	
	@RequestMapping("RetriveAll")
	public ModelAndView retriveAll() {

		List<EmpModel> EmpList = services.viewAllEmployees();
		ModelAndView mv = new ModelAndView("AllEmp");
		mv.addObject("EmpList", EmpList);
		return mv;
	}
	
	@RequestMapping("empSearch")
	public ModelAndView empSearch(int eno){
		
		EmpModel emp = services.searchEmp(eno);
		ModelAndView mv = new ModelAndView("searchResult");
		mv.addObject("emp", emp);
		return mv;
		
	}
	
	@RequestMapping("deleteEmp")
	public ModelAndView deleteEmp(int eno) {
	
		EmpModel emp = services.searchEmp(eno);
		services.removeEmployee(eno);
		ModelAndView mv = new ModelAndView("deleteResult");
		mv.addObject("emp", emp);
		return mv;
	}
	
	@RequestMapping("updateEmp")
	public ModelAndView updateEmp(int eno,String ename,int sal) {
		
		EmpModel emp = services.searchEmp(eno);
		services.updateEmp(emp, ename, sal);
		ModelAndView mv = new ModelAndView("updateResult");
		mv.addObject("emp", emp);
		return mv;
	}
}
