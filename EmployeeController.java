package com.emoloyee.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emoloyee.entity.Employee;
import com.emoloyee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
		
	@Autowired
		private EmployeeService emp_ser;
		
		@PostMapping("/saveEmployee")
		public Employee saveEmployee(@RequestBody Employee emp) {
			return emp_ser.saveEmployee(emp);
		}
		
		@GetMapping("/getAllEmployee")
		public HashMap<String, Object> getEmployee() {
			return emp_ser.getEmployee();
		}
		
//		@GetMapping("/getUserWithDepartment/{user_id}")
//		public ResponseTemplate getUserWithDepartment(@PathVariable Integer user_id) {
//			return user_ser.getUserWithDepartment(user_id);
//		}

}
