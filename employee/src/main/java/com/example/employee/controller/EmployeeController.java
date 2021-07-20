package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	    @Autowired
	    private EmployeeService empservice;

	    @PostMapping("/addemployee")
	    public Employee createEmployee( @RequestBody Employee employee) {
	        return empservice.createTheEmployee(employee);
	    }
	    
	    @GetMapping("/getemployee")
	    public List < Employee > getAllEmployees() {
	        return empservice.getEmployees();
	    }
	    
	    @GetMapping("/getemployee/{email}")
	    public List <Employee> getEmailEmployees(@PathVariable String email) {
	        return empservice.getEmailOfEmployees(email);
	    }
	    
	    @GetMapping("/getemployeebyname")
	    public List < Employee > getNameEmployees(@RequestParam String name) {
	        return empservice.getNameOfEmployees(name);
	    }
	    
	    @DeleteMapping("/deleteemployee/{id}")
	    public void deleteEmployee(@PathVariable int id) {
	    	empservice.deleteTheEmployee(id);
	    }
	    
	    @PutMapping("/updateemployee")
	    public Employee updateEmployee(@RequestParam int id, @RequestBody Employee emp) {

	    	return empservice.updateTheEmployee(id, emp);
	    }
	    
	    

}
