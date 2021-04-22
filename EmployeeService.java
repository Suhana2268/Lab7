package com.cg.eis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.cg.eis.beans.*;

public interface EmployeeService {
	
	public HashMap<String, Set<Employee>> insertEmployee(Employee e);
	public HashMap<String, Set<Employee>> getAllEmployees();
	public HashMap<String, Set<Employee>> getAllEmployeesByInsurance(String insurance);
	public List<Employee> deleteEmployee(int id, String name);

}
