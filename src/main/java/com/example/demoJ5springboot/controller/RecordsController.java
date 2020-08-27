package com.example.demoJ5springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demoJ5springboot.entity.Records;
import com.example.demoJ5springboot.entity.Staffs;
import com.example.demoJ5springboot.service.MailService;
import com.example.demoJ5springboot.service.RecordsService;
import com.example.demoJ5springboot.service.StaffService;



@Controller
public class RecordsController {
	@Autowired 
	RecordsService recordService;
	
	@Autowired
	StaffService staffService;
	
	@Autowired
	MailService mailService;
	
	@RequestMapping(value = "record")
	public String record(ModelMap model) {
		model.addAttribute("records",new Records());
		model.addAttribute("list_record", recordService.findAll());
		return "record";
	}
	@ModelAttribute("list_staff")
	public List<Staffs> getStaf(){
		return staffService.findAll();
	}
	
	@RequestMapping(value = "record",params = "add")
	public String addRecord(@ModelAttribute("records") Records re) {
		recordService.save(re);
		mailService.sendEmail(re);
		return "redirect:record";
	}
	@RequestMapping(value = "record",params = "update")
	public String updateRecord(@ModelAttribute("records") Records re) {
		recordService.save(re);
		return "redirect:record";
	}
	@RequestMapping(value = "record",params = "delete")
	public String deleteRecord(@ModelAttribute("records") Records re) {
		recordService.delete(re);
		return "redirect:record";
	}
	@RequestMapping(value = "/record_edit{id}")
	public String edit(@PathVariable("id") String id,ModelMap model ) {
		model.addAttribute("list_record", recordService.findAll());
		model.addAttribute("records", recordService.findById(Integer.parseInt(id)));
		return "record";
	}
	@RequestMapping(value = "/record_delete{id}")
	public String delR(@PathVariable("id") String id,ModelMap model ) {
		recordService.deleteById(Integer.parseInt(id));
		return "redirect:record";
	}
}
