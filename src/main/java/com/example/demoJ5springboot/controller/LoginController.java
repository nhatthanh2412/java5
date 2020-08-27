package com.example.demoJ5springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demoJ5springboot.service.UsersService;



@Controller
public class LoginController {
	@Autowired
	UsersService userService;
	
	@RequestMapping(value = "")
	public String getlogin() {
		return "login";
	}
	@RequestMapping(value = "login")
	public String postlogin(HttpServletRequest rq) {
		if(userService.checkLogin(rq.getParameter("user"), rq.getParameter("pass"))) {
			return "main";
		}else {
			return "redirect:";
		}
	}
}
