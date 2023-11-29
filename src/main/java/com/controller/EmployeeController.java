package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.EmployeeEntity;
import com.service.EmployeeService;



@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	
	@GetMapping("/deleteEmployee")
	 
	  String deleteEmp(@RequestParam int employeeId,Model model){
		
		employeeService.deleteEmp(employeeId);
		
		//now fetch all fresh records from db
		
		//send all the latest records to showAll.jsp
		
		
	 
	 return "redirect:showAll"; //showAll.jsp
	 
	}
	
	@GetMapping({"/registation","/"})
	 
	  String displayRegistrationPage(){
	 
	 return "registation"; 
	 
	}
	
	@PostMapping("/register")
	 
	  String doRegistration(@ModelAttribute EmployeeEntity employeeEntity ,Model model){
		
		employeeService.saveEmployee(employeeEntity);
		
		
		System.out.println(employeeEntity);
		model.addAttribute("msg", "registration done");
	 
	 return "registation"; 
	 
	}
	
	@GetMapping("/login")
	 
	  String displayLoginPage(){
	 
	 return "mylogin"; //mylogogin.jsp
	 
	}
	@PostMapping("/login")
	 
	  String doLogin(@RequestParam String email,@RequestParam String password,Model model){
		
	EmployeeEntity employeeEntity=employeeService.authenticate(email,password);
		
		if(employeeEntity!=null) {
			
		 model.addAttribute("employeeEntity", employeeEntity);
			
			return "congrates";
		}
		else {
		
		 model.addAttribute("msg", "invalid credentials..plz try again");
		 return "mylogin"; 
		 
		}	 
	 
	}
	
	
	@GetMapping("/showAll")
	 
	  String displayAllRecords(Model model){
		
		List<EmployeeEntity> listOfEmployees=employeeService.findAllEmployees();
		
		 model.addAttribute("listOfEmployees", listOfEmployees);
		
	 
	 return "showAll"; //showAll.jsp
	 
	}
}
