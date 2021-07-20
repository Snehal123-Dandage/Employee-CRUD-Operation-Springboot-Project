package com.example.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
    private EmployeeRepo repo;
	
	public Employee createTheEmployee(Employee employee) {
        return repo.save(employee);
    }
	
	public List < Employee > getEmployees() {
        return repo.findAll();
    }
	
	 public List <Employee> getEmailOfEmployees(String email) {
	        return repo.findByEmail(email);
	 }
	 
	 public List < Employee > getNameOfEmployees(String name) {
	        return repo.findByName(name);
	    }
	 
	 public void deleteTheEmployee(int id) {
    	 repo.deleteById(id);
    }
	 
	 public Employee updateTheEmployee( int id, Employee emp) {

	    	Optional<Employee> existing = repo.findById(id);
	    	if(existing.isPresent()) {
	    		Employee e = existing.get();
	    		
	    		if(emp.getEmail() != null) {
		    	e.setEmail(emp.getEmail());
	    		}
	    		
	    		if(emp.getName() != null) {
		    	e.setName(emp.getName());
	    		}
		    	return repo.save(e);
	    	}
	    	return null;
	    	
	    }

}
