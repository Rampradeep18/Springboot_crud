package com.jsp.boot_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.boot_crud.dto.EmployeeDto;
import com.jsp.boot_crud.respository.Repository;

@Controller
public class MyController {

	@Autowired
	Repository repository;

	@GetMapping("/")
	public String loadHome() {
		return "home.html";
	}

	@GetMapping("/add-record")
	public String addRecord(ModelMap map) {
		map.put("add", "add");
		return "home.html";
	}

	@PostMapping("/add-record")
	public String addRecord(EmployeeDto employee, ModelMap map) {
		repository.save(employee);
		map.put("success", "Record Added Success");
		return "home.html";
	}

	@GetMapping("/fetch-records")
	public String fetchRecords(ModelMap map) {
		map.put("records", repository.findAll());
		return "home.html";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam int id, ModelMap map) {
		EmployeeDto employee = repository.findById(id).orElseThrow();
		map.put("emp", employee);
		map.put("edit", "edit");
		return "home.html";
	}

	@PostMapping("/update-record")
	public String updateRecord(EmployeeDto employee, ModelMap map) {
		repository.save(employee);
		map.put("success", "Record Updated Success");
		return "home.html";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam int id, ModelMap map) {
		repository.deleteById(id);
		map.put("success", "Record Deleted Success");
		return "home.html";
	}

}
