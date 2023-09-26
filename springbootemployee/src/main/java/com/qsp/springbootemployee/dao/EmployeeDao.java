package com.qsp.springbootemployee.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springbootemployee.dto.Employee;
import com.qsp.springbootemployee.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	
	@Autowired
	private EmployeeRepo repo;

	public Employee saveEmployee(Employee employee)
	{
		return repo.save(employee);
	}
	
	
	public Employee findEmployee(int id)
	{
//		return repo.findById(id).get();
		
//		to avoid NoSuchElementException we used optional class
//   to check when data is present		
		Optional<Employee> optional=repo.findById(id);       // to check when data is empty or not
		if(optional.isPresent())                            //  if(optional.isEmpty())
			                                               //  {
		{                                                  //   return null;
			return optional.get();                        //    }
		}
		                                                  //  return optional.get()
		return null;
		
	}
																																																																																									
	
	public List<Employee> getAllEmployee()
	{
		return repo.findAll();
	}
	
	
	//for delete method we have 2 method--->1.deletById(id) 2.delete(entity)
	
	//1.deleteById(id)
	public Employee deleteEmployee(int id)
	{
		Optional<Employee> optional=repo.findById(id);
		
			if(optional.isPresent())
			{
				repo.deleteById(id);
				return optional.get(); 
			}
		
		return null;
	}
	
	//2.delete(entity obj)
//	public Employee deleteEmployee(int id)
//	{
//		Optional<Employee> optional=repo.findById(id);
		
//			if(optional.isPresent())
//			{
//	        Employee employee=optional.get();
	
//				repo.delete(employee);
//				return employee; 
//			}
//		
//		return null;
//	}
	
	
	public Employee updateEmployee(int id,Employee employee)
	{
		Optional<Employee> optional=repo.findById(id);
		if(optional.isEmpty())
		{
			return null;
		}
		employee.setId(id);
		return repo.save(employee);
		 
		
	}
	
	
	public Employee findByEmail(String Email)
	{
		return repo.findEmployeeByEmail(Email);
	}
	
	public Employee findByPhone(long phone)
	{
//		return repo.getEmployeeByPhone(phone);
		return repo.empByPhone(phone);
	}
	
	public List<Employee> salaryGreaterThan(double salary)
	{
		return repo.findEmployeeBySalaryGreaterThan(salary);
	}
	
	
	public List<Employee> salaryLessThan(double salary)
	{
		return repo.findEmployeeBySalaryLessThan(salary);
	}


	
	
	
	
	
	
	

}
