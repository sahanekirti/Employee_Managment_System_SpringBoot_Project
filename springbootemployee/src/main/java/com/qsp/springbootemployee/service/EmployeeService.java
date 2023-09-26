package com.qsp.springbootemployee.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.qsp.springbootemployee.dao.EmployeeDao;
import com.qsp.springbootemployee.dto.Employee;
import com.qsp.springbootemployee.exception.EmailNotFound;
import com.qsp.springbootemployee.exception.IdNotFound;
import com.qsp.springbootemployee.exception.PhoneNotFound;
import com.qsp.springbootemployee.util.ResponseStructure;

@Service
public class EmployeeService {
	 
	@Autowired
	private EmployeeDao dao;
	
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee)
	{
		double salary=employee.getSalary();
		
		if(salary<10000)
		{
			employee.setGrade('A');
		}
		else if(salary>=10000 && salary <20000)
		{
			employee.setGrade('B');
		}
		else if(salary>=20000 && salary <40000)
		{
			employee.setGrade('C');
		}
		else
		{
			employee.setGrade('D');
		}
		
		ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
		structure.setMessage("saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveEmployee(employee));
		
		return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<Employee>> findEmployee(int id)
	{
		
		Employee employee=dao.findEmployee(id);
		
		ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
		
		if(employee != null)
		{
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(employee);
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.FOUND);
		}
		else
//		{
//			structure.setMessage(" NOT Found ");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setData(employee);
			throw new IdNotFound("id not found");
			
		}
		
		
//	}
	
	public ResponseEntity<ResponseStructure<Employee>> getAllEmployee()
	{
		ResponseStructure<List<Employee>> structure=new ResponseStructure<>(); 
		List<Employee> list=dao.getAllEmployee();
		if(list.isEmpty())
		{
			structure.setMessage("Not found Data");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(list);
			
			return new ResponseEntity<ResponseStructure<Employee>>(HttpStatus.NOT_FOUND);
				
		}
		else
		{
			structure.setMessage(" find successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			
			return new ResponseEntity<ResponseStructure<Employee>>(HttpStatus.FOUND);
			
			}
	
		
	}
	
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(int id)
	{
		ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
		
		structure.setMessage("deleted successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.deleteEmployee(id));
		
		return  new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(int id,Employee employee)
	{
          double salary=employee.getSalary();
		
		if(salary<10000)
		{
			employee.setGrade('A');
		}
		else if(salary>=10000 && salary <20000)
		{
			employee.setGrade('B');
		}
		else if(salary>=20000 && salary <40000)
		{
			employee.setGrade('C');
		}
		else
		{
			employee.setGrade('D');
		}
		
ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
		
		structure.setMessage("update successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.updateEmployee(id,employee));
		
		return  new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmail(int id, String email) {
		
		Employee employee=dao.findEmployee(id);
		employee.setEmail(email);
		
    ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
		
		structure.setMessage("updated successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(employee);
		
		return  new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.CREATED);

	}
	
    public ResponseEntity<ResponseStructure<Employee>> updatePhone(int id, long phone) {
		
		Employee employee=dao.findEmployee(id);
		employee.setPhone(phone);
		

	    ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
			
			structure.setMessage("updated successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(employee);
			
			return  new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.CREATED);
			
		
	}
    
    
public ResponseEntity<ResponseStructure<Employee>> updateSalary(int id, double salary) {
		
		Employee employee=dao.findEmployee(id);
		employee.setSalary(salary);
		

	    ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
			
			structure.setMessage("updated successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(employee);
			
			return  new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.CREATED);
		
		
	}


   public ResponseEntity<ResponseStructure<Employee>> findByEmail(String email)
   {
	  
        Employee employee=dao.findByEmail(email);

	    ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
			
	    
	    if(email != null)
		{
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.findByEmail(email));
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.FOUND);
			
		}
			else
			{
				structure.setMessage(" NOT Found ");
				structure.setStatus(HttpStatus.NOT_FOUND.value());
				structure.setData(dao.findByEmail(email));
				
				throw new EmailNotFound("email not found");
				
			}
			
			
		
	   
   }
	
   
   public ResponseEntity<ResponseStructure<List<Employee>>> findByPhone(long phone)
   {
	   Employee employee=dao.findByPhone(phone);
	    ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
			
	   if(employee != null)
	    {
	    
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.findByPhone(phone));
			
			return new ResponseEntity<ResponseStructure<List<Employee>>>(HttpStatus.FOUND);
  }
			else
			{
				structure.setMessage(" NOT Found ");
				structure.setStatus(HttpStatus.NOT_FOUND.value());
				structure.setData(dao.findByPhone(phone));
				
				throw new PhoneNotFound("given phone not found");
				
			}
			
			
   }		
  
   public ResponseEntity<ResponseStructure<List<Employee>>> salaryGreaterThan(double salary)
   {

		ResponseStructure<List<Employee>> structure=new ResponseStructure<>(); 
		List<Employee> list=dao.salaryGreaterThan(salary);
		if(list.isEmpty())
		{
			structure.setMessage("Not found Data");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(list);
			
		return new ResponseEntity<ResponseStructure<List<Employee>>>(HttpStatus.NOT_FOUND);
				
		}
		else
		{
			structure.setMessage(" find successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(HttpStatus.FOUND);
			
			}
		
	}
	
   public ResponseEntity<ResponseStructure<List<Employee>>> salaryLessThan(double salary)
   {
	   
	   ResponseStructure<List<Employee>> structure=new ResponseStructure<>(); 
		List<Employee> list=dao.salaryLessThan(salary);
		if(list.isEmpty())
		{
			structure.setMessage("Not found Data");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(list);
			
			return new ResponseEntity<ResponseStructure<List<Employee>>>(HttpStatus.NOT_FOUND);
				
		}
		else
		{
			structure.setMessage(" find successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			
			return new ResponseEntity<ResponseStructure<List<Employee>>>(HttpStatus.FOUND);
			
			}
		

	    
   }
   
   
   
	
	
	

}
