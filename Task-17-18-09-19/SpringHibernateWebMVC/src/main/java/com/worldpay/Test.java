package com.worldpay;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Test {

	@RequestMapping("check")
	public String check() {
		System.out.println("sucesss=============================>");
		return "CheckResult.jsp";
	}
}
