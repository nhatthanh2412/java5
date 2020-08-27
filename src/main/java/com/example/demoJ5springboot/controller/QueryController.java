package com.example.demoJ5springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demoJ5springboot.service.RecordsService;




@Controller
public class QueryController {
	@Autowired
	RecordsService recordService;
	
	@RequestMapping(value = "canhan")
	public String canhan(ModelMap model) {
		model.addAttribute("list_canhan", recordService.find_record_staff());
		model.addAttribute("list_phongban", recordService.find_record_depart());
		return "canhan";
	}
}