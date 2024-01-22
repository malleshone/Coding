package com.example.demo;

public class Employee {

	public int employeeId;
	public String employeeName;
	public String company;
	public int salary;

	public Employee() {
		super();
	}

	public Employee(int employeeId, String employeeName, String company, int salary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.company = company;
		this.salary = salary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", company=" + company
				+ ", salary=" + salary + "]";
	}

}