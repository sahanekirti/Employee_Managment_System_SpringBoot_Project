package com.qsp.springbootemployee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springbootemployee.dao.EmployeeDao;
import com.qsp.springbootemployee.dto.Employee;
import com.qsp.springbootemployee.service.EmployeeService;
import com.qsp.springbootemployee.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeDao dao;
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/save")
	@ApiOperation(value="Save Employee", notes="this api is uesd to save the employeedata into db")
	@ApiResponses(value = {@ApiResponse(code=201,message = "data saved successfully")})
	
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@Valid  @RequestBody Employee employee)
	
	{
		return service.saveEmployee(employee);
		
	}
	
	@GetMapping("/fetch")
	
	@ApiOperation(value="Find Employee", notes="this api is uesd to find the employeedata into db")
	@ApiResponses(value = {@ApiResponse(code=302,message = "data not found")})
	
	public ResponseEntity<ResponseStructure<Employee>> findEmployee(@Valid  @RequestParam int id)
	{
		return service.findEmployee(id);
	}
	
	@GetMapping("/fetchAll")
	@ApiOperation(value="Find All Employee", notes="this api is uesd to find all the employeedata into db")
	@ApiResponses(value = {@ApiResponse(code=302,message = "data not found")})
	
	public ResponseEntity<ResponseStructure<Employee>> getAllEmployee()
	{
		return service.getAllEmployee();
	}
	
	@DeleteMapping("/delete/{id}")
	
	@ApiOperation(value="Delete Employee", notes="this api is uesd to delete the employeedata into db")
	@ApiResponses(value = {@ApiResponse(code=302,message = "data not found")})
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@Valid @PathVariable int id)
	{
		return service.deleteEmployee(id);
	}
	
	
	//for update 2 methods -->1.put 2.patch
	// 1.put--->is used for update all data
	//2.patch--->is used for update single data
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestParam int id,@RequestBody  Employee employee) {
		return service.updateEmployee(id, employee);
		
	}
	
	@PatchMapping("/updateemail/{id}")
	public ResponseEntity<ResponseStructure<Employee>> updateEmail( @PathVariable int id,  @RequestParam  String email)
	{
		return service.updateEmail(id,email);
		
	}
	
	@PatchMapping("/updatePhone/{id}")
	public ResponseEntity<ResponseStructure<Employee>> updatePhone(@PathVariable int id,@RequestParam  long phone)
	{
		return service.updatePhone(id, phone);
	}
	
	@PatchMapping("updateSalary/{id}")
	public ResponseEntity<ResponseStructure<Employee>> updateSalary(@PathVariable int id, @RequestParam double salary)
	{
		return service.updateSalary(id, salary);
	}
	
	
	@GetMapping("/findByEmail")
	 public ResponseEntity<ResponseStructure<Employee>> findByEmail(@Valid  @RequestParam  String email)
	 {
		 return service.findByEmail(email);
	 }
	
	@GetMapping("/findByPhone")
	public ResponseEntity<ResponseStructure<List<Employee>>> findByPhone(@Valid  @RequestParam   long phone)
	{
		return service.findByPhone(phone);
	}
	
	@GetMapping("/salaryGreaterThan")
	public ResponseEntity<ResponseStructure<List<Employee>>> salaryGreaterThan(@RequestParam   double salary)
	{
		return service.salaryGreaterThan(salary);
	}
	 
	@GetMapping("/salaryLessThan")
	public ResponseEntity<ResponseStructure<List<Employee>>> salaryLessThan(@RequestParam double salary)
	{
		return service.salaryLessThan(salary);
	}
	  
	
	

}
