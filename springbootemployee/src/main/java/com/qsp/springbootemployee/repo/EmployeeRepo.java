package com.qsp.springbootemployee.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.springbootemployee.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee , Integer> {
	
// two keyword findBy 2.getBy	
	
	
	Employee findEmployeeByEmail(String email);

//	Employee getEmployeeByPhone(long phone);
	
	@Query("select e from Employee e where e.phone=?1")
	Employee empByPhone(long phone);
	
//3.keyword--->GreaterThan
	
	List<Employee> findEmployeeBySalaryGreaterThan(double salary);
	
//4.LessThan	
	List<Employee> findEmployeeBySalaryLessThan(double salary);
	
}
