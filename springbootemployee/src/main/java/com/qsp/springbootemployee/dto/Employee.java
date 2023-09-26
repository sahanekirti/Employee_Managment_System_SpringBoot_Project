package com.qsp.springbootemployee.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Columns;

//import lombok.Data;

@Entity
//@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message="name can't be Blank")
	@NotNull(message="name can't be Null")
	private String name;
	
	@Column(unique=true)
//	@Pattern(regexp = "[6-9][0-9]{9}") =>regexp can be used only string type
	@Min(value=6000000000l)
	@Max(value=9999999999l)
	private Long phone;
	
	@Column(unique=true)
//	@NotBlank(message="email can't be blank")
//	@NotNull(message="email can't be Null")
	@Email(regexp = "[a-z0-9]+@[a-z]+[a-z0-9]+\\.{2,3}" ,message="invalid emial")
	private String email;
	
	@NotBlank(message="address can't be blank")
	@NotNull(message="address can't be Null")
	private String address;
	
	@Min(value=1)
	
	private double salary;
	private char grade;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	
	
	
	
	
	
	
	
	

}
