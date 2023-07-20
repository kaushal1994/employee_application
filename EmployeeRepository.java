package com.emoloyee.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emoloyee.entity.Employee;

@Transactional
@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{
	

	@Query(value = "select new map(emp.employee_id as employee_id,emp.first_name as first_name,emp.last_name as last_name,"
			+ "emp.email as email,emp.phone_number as phone_number,emp.doj as doj,"
			+ "emp.salary_per_month as salary_per_month) "
			+ "from Employee emp ")
	public List<HashMap<String, Object>> getData();

}
