package com.service;

import java.util.List;

import com.entity.EmployeeEntity;

public interface EmployeeService {

	void saveEmployee(EmployeeEntity employeeEntity);

	List<EmployeeEntity> findAllEmployees();

	EmployeeEntity authenticate(String email, String password);

	void deleteEmp(int employeeId);

	EmployeeEntity fetchEmpByEmail(String email);

	

	
	

	

}
