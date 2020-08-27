package com.example.demoJ5springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demoJ5springboot.entity.Departs;
import com.example.demoJ5springboot.service.DepartsService;



@Controller
public class DepartController {
	@Autowired
	DepartsService departSevice;
	
	@GetMapping(value = "depart")
	public String getALl(ModelMap model) {
		Departs a=new Departs("IT","Phan mem");
		Departs b=new Departs("DS","Do hoa");
		departSevice.save(a);
		departSevice.save(b);
		model.addAttribute("list_depart", departSevice.findAll());
		model.addAttribute("departs", new Departs());
		return "depart";
	}
	@RequestMapping(value = "depart",params = "add")
	public String addDepart(@ModelAttribute("departs") Departs de ) {
		departSevice.save(de);
		return "redirect:depart";
	}
	@RequestMapping(value = "depart",params = "update")
	public String update(@ModelAttribute("departs")Departs de) {
		departSevice.save(de);
		return "redirect:depart";
	}
	@RequestMapping(value = "depart",params = "delete")
	public String delDepart(@ModelAttribute("departs")Departs de) {
		departSevice.delete(de);
		return "redirect:depart";
	}
	@RequestMapping(value = "/depart_delete{id}")
	public String deleteDepart(@PathVariable("id") String id) {
		departSevice.deleteById(id);
		return "redirect:depart";
	}
	@RequestMapping(value = "/depart_edit{id}")
	public String edit(@PathVariable("id") String id, ModelMap model) {
		model.addAttribute("list_depart", departSevice.findAll());
		model.addAttribute("departs",departSevice.findById(id));
		return "depart";
	}
	
}
