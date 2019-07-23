package com.example.SwaggerPOC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.SwaggerPOC.model.Employee;
import com.example.SwaggerPOC.repository.EmpRepo;

@SuppressWarnings("unused")
@RestController
public class EmployeeController {
	
	@Autowired
	EmpRepo emp;
     
    @GetMapping(path="/employees/{Id}", produces = "application/json")
    public ResponseEntity<Employee> getEmployees(@PathVariable String Id)
    {
    	Employee employee = emp.findById(Id);
    	return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }
     
    @PostMapping(path="/employees", produces = "application/json")
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
    	 emp.save(employee);
    	 return new ResponseEntity<>("Employee detail is created successfully", HttpStatus.CREATED);
    }
    
    @PutMapping(path="/employees/{Id}", produces = "application/json")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, @PathVariable String Id){
    	employee = emp.findById(Id);
    	employee.setFirstName("am");
    	emp.save(employee);
    	
    	return new ResponseEntity<>("Employee is updated successsfully", HttpStatus.OK);
    }
    
    
    @DeleteMapping(path="/employees/{Id}", produces = "application/json")
    public ResponseEntity<Object> deleteEmployee(@PathVariable String Id){
    	emp.deleteAll();
    	return new ResponseEntity<>("Employee is deleted successsfully", HttpStatus.OK);
    }
    
}
