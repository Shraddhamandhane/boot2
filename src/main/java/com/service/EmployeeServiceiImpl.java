package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeDao;
import com.entity.EmployeeEntity;

@Service
@Transactional
public class EmployeeServiceiImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public void saveEmployee(EmployeeEntity employeeEntity) {
		
		employeeDao.save(employeeEntity);	
		
	}

	@Override
	public List<EmployeeEntity> findAllEmployees() {
		List<EmployeeEntity> listOfEmployeeEntity = employeeDao.findAll();// findAll() is inbuilt method
		
		return listOfEmployeeEntity;
	}

	@Override
	public EmployeeEntity authenticate(String email, String password) {
EmployeeEntity employeeEntity=employeeDao.findByEmailIdAndPassword(email,password);
		
		
		
		return employeeEntity;
	}

	@Override
	public void deleteEmp(int employeeId) {
		employeeDao.deleteById(employeeId);
		
	}

	@Override
	public EmployeeEntity fetchEmpByEmail(String email) {
		EmployeeEntity employeeEntity=employeeDao.findByEmailId(email);
		
		return employeeEntity;
	}

	

	
}
