package com.example.SwaggerPOC.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.SwaggerPOC.model.Employee;

@Repository
public interface EmpRepo extends CrudRepository<Employee, Long>{

	Employee findById(String Id);
}
