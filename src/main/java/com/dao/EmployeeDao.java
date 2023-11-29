package com.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.EmployeeEntity;

public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer>{
	
	EmployeeEntity findByEmailIdAndPassword(String email, String password);//derived method/query


	EmployeeEntity findByEmailId(String email);
	
	

}
