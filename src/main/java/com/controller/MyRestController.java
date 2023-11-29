package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.EmployeeEntity;
import com.service.EmployeeService;

@RestController
@RequestMapping("/v2")
public class MyRestController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees") // localhost:999/v2/employees

	ResponseEntity<List<EmployeeEntity>> fetchAllEmployees() {

		List<EmployeeEntity> employeeList = employeeService.findAllEmployees();

		return new ResponseEntity<>(employeeList, HttpStatus.OK);

	}

	@GetMapping("/employees/{email}")//localhost:999/v2/employees/s@gmail.com
	
	ResponseEntity<?> fetchEmployee(@PathVariable String email){	
		
		EmployeeEntity employeeEntity=employeeService.fetchEmpByEmail(email);
		if(employeeEntity !=null) {
		
		return new ResponseEntity<>(employeeEntity,HttpStatus.OK);		
	}
		else {
			return new ResponseEntity<>("this email does not exist",HttpStatus.OK);	//ok==200
			
		}
}
	
	@PostMapping("/employees")
	ResponseEntity<String> registerEmployee(@RequestBody EmployeeEntity employeeEntity){
		
		employeeService.saveEmployee(employeeEntity);
		return new ResponseEntity<>("registration done successfully",HttpStatus.CREATED);//created=201	
		
		
		
	}
}
