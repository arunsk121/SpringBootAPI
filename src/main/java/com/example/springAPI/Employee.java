package com.example.springAPI;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee implements Comparable<Employee> {
	
	//data
	@Id
	@Column(name="empid")
	private int empId;
	@Column
	private String name;
	@Column
	private String department;
	@Column
	private double salary;
	
	//getters & setters
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	@Override
	public int compareTo(Employee o) {
		return (int) (o.getSalary() - this.getSalary());
	}

}
