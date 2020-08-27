package com.example.demoJ5springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demoJ5springboot.entity.Users;
import com.example.demoJ5springboot.service.UsersService;



@Controller
public class UsersController {
	@Autowired 
	UsersService userService;
	
	
	@GetMapping(value = "user")
	public String getUser(ModelMap model) {
		Users a3= new Users("duyen","123","Nguyen Thi My Duyen");
		Users a= new Users("thanh","123","Huynh Nhat Thanh");
		Users a2= new Users("sang","123","Ha Minh Sang");
		userService.save(a3);
		userService.save(a);
		userService.save(a2);
		model.addAttribute("list_user",userService.findAll());
		model.addAttribute("users", new Users());
		return "user";
	}
	@RequestMapping(value = "user",params = "add")
	public String addUser(@ModelAttribute("users") Users user ) {
		userService.save(user);
		return"redirect:user";
	}
	@RequestMapping(value = "user",params = "update")
	public String updateUser(@ModelAttribute("users") Users user)  {
		userService.save(user);
		return "redirect:user";
	}
	@RequestMapping(value = "user",params = "delete")
	public String deleteUser(@ModelAttribute("users") Users user) {
		userService.delete(user);
		return "redirect:user";
	}
	@RequestMapping(value = "/user_edit{id}")
	public String edit(@PathVariable("id") String id,ModelMap model ) {
		model.addAttribute("users", userService.getOne(id));
		model.addAttribute("list_user",userService.findAll());
		return "user";
	}
	@RequestMapping(value = "/user_delete{id}")
	public String delete(@PathVariable("id") String id ) {
		userService.deleteById(id);
		return "redirect:user";
	}
}
