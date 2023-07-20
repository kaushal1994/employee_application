package com.emoloyee.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emoloyee.entity.Employee;
import com.emoloyee.repository.EmployeeRepository;

@Service
public class EmployeeService {
		
	@Autowired
		private EmployeeRepository emp_repo;
		
		public Employee saveEmployee(Employee user) {
			return emp_repo.save(user);
		}
		
		Double amount2=0.0;
		Double amount1=0.0;
		Double amount =0.0;
		Double tax_amount=0.0;
		public HashMap<String, Object> getEmployee() {
			
			List<HashMap<String, Object>> list = emp_repo.getData();
			
			HashMap<String, Object> list1 = new HashMap<String, Object>();
//			List<Employee> list1 = new ArrayList<Employee>();

			
			list.stream().forEach(l -> {

				Double yearly_salary = ((Double)l.get("salary_per_month"))*12;
				
				if(yearly_salary <= 250000) {
					tax_amount=0.0;
				}
				else if(yearly_salary>250000 && yearly_salary<=500000) {
					 amount = (yearly_salary-250000)*5/100;
					tax_amount=amount;	
				}
				else if(yearly_salary>500000 && yearly_salary<=1000000) {
					amount =(Double)(250000*5/100.0);
					amount1=(yearly_salary-500000)*10/100;
					tax_amount=amount+amount1;
				}
				else if(yearly_salary>1000000) {
					amount =(Double)(250000*5/100.0);
					amount =(Double)(500000*5/100.0);
					amount2=(yearly_salary-1000000)*20/100;
					tax_amount=amount+amount1+amount2;
				}
				l.put("tax_amount", tax_amount);
				
				list1.put(l.get("employee_id").toString(), l);

			});
			
			return list1;
		}

}
