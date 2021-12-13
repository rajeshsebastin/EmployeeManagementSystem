package com.employedatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.employedatabase.entity.Emp;
import com.employedatabase.repository.EmpRepository;
import com.employedatabase.service.EmpService;
 
@RestController
@RequestMapping(value = "/emp")
public class empController {
	
	@Autowired
	private EmpService empService;
	
	 @PostMapping("/saveemp")
	@ResponseBody
    public Emp saveEmp(@RequestBody Emp emp) {
		Emp empResponse = empService.saveEmp(emp);
		return empResponse;
	}
	
	 @GetMapping("/{empId}")
	@ResponseBody
    public Emp getEmpDetails(@PathVariable int empId) {
		Emp empResponse = empService.findByEmpId(empId);
		
		return empResponse;
	}

	@Autowired
	private EmpRepository repo;
	
	  @DeleteMapping("/{empId}")
	    public HttpStatus deleteemp(@PathVariable int empId) {
	        repo.deleteById(empId);
	        return  HttpStatus.FORBIDDEN;
	}

	
	
}