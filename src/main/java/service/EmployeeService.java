package service;

import java.util.List;

import dataObjects.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	public Employee addUser(Employee employee);

}
