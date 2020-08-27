package com.example.demoJ5springboot.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demoJ5springboot.entity.Departs;
import com.example.demoJ5springboot.entity.Staffs;
import com.example.demoJ5springboot.service.DepartsService;
import com.example.demoJ5springboot.service.StaffService;


@Controller
public class StaffsController {
	@Autowired
	StaffService staffService;

	@Autowired
	DepartsService departService;

	@ModelAttribute("list_depart")
	public List<Departs> getDe() {
		return departService.findAll();
	}

	@RequestMapping(value = "staff")
	public String get(ModelMap model) {
		Staffs a = new Staffs("NV1", "Thanh", true, new Date(), "a.jpg", "thanh@gmail.com", "0987654321", 9000, "",
				departService.findById("IT").get());
		staffService.save(a);
		model.addAttribute("list_staff", staffService.findAll());
		model.addAttribute("staffs", new Staffs());
		return "staff";
	}

	@RequestMapping(value = "staff", params = "add")
	public String addStaff(@ModelAttribute("staffs") Staffs sta) {
		staffService.save(sta);
		return "redirect:staff";
	}

	@RequestMapping(value = "getimage/{photo}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ByteArrayResource> getImage(@PathVariable("photo") String photo) {
		if (!photo.equals("") || photo != null) {
			try {
				Path filename = Paths.get("upload-dir", photo);
				byte[] buffer = Files.readAllBytes(filename);
				ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
				return ResponseEntity.ok().contentLength(buffer.length)
						.contentType(MediaType.parseMediaType("image/png")).body(byteArrayResource);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return ResponseEntity.badRequest().build();
	}

	@RequestMapping(value = "staff", params = "app")
	public String appStaff(@ModelAttribute("staffs") Staffs sta, ModelMap model,
			@RequestParam("file") MultipartFile file) {
		Path path = Paths.get("upload-dir");
		try {
			InputStream inputStream = file.getInputStream();
			Files.copy(inputStream, path.resolve(file.getOriginalFilename()), 
					StandardCopyOption.REPLACE_EXISTING);
			sta.setPhoto(file.getOriginalFilename().toLowerCase());
		} catch (Exception e) {

		}
		model.addAttribute("staffs", sta);
		model.addAttribute("list_staff", staffService.findAll());
		return "staff";
	}

	@RequestMapping(value = "staff", params = "update")
	public String updateStaff(@ModelAttribute("staffs") Staffs sta) {
		staffService.save(sta);
		return "staff";
	}

	@RequestMapping(value = "staff", params = "delete")
	public String delateStaff(@ModelAttribute("staffs") Staffs sta) {
		staffService.delete(sta);
		return "redirect:staff";
	}

	@RequestMapping(value = "/staff_edit{id}")
	public String edit(@PathVariable("id") String id, ModelMap model) {
		model.addAttribute("list_staff", staffService.findAll());
		Staffs sta=staffService.findById(id).get();
		model.addAttribute("staffs",sta );
		return "staff";
	}

	@RequestMapping(value = "/staff_delete{id}")
	public String delStaff(@PathVariable("id") String id, ModelMap model) {
		staffService.deleteById(id);
		return "redirect:staff";
	}
}
