package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = { "/", "employee"})
public class HomeController {
		@RequestMapping("home")
		public String Home() {
			return "employee/home";
		}
		
		@RequestMapping("userhome")
		public String userHome() {
			return "employee/userhome";
		}
		
		@RequestMapping("403")
		public String Error403() {
			return"403";
		}
}
