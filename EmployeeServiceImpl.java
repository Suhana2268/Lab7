package com.cg.eis.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.cg.eis.beans.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	
	HashMap<String, Set<Employee>> hm = new HashMap<String, Set<Employee>>();
	

	public HashMap<String, Set<Employee>> insertEmployee(Employee e) {
		// TODO Auto-generated method stub
		if(e.getSalary() > 5000 && e.getSalary() < 20000 && e.getDesignation().equals("System Associate")) {
			e.setInsuranceScheme("Scheme C");
		}
		else if(e.getSalary() >= 20000 && e.getSalary() < 40000 && e.getDesignation().equals("Programmer")) {
			e.setInsuranceScheme("Scheme B");
		}
		else if(e.getSalary() >= 40000 && e.getDesignation().equals("Manager")) {
			e.setInsuranceScheme("Scheme A");
		}
		else if(e.getSalary() <= 5000 && e.getDesignation().equals("Clerk")) {
			e.setInsuranceScheme("No Scheme");
		}
		Set<Employee> se = new HashSet<Employee>();
		se.add(e);
		hm.put(e.getInsuranceScheme(), se);
		
		
		return hm;
	}

	public HashMap<String, Set<Employee>> getAllEmployees() {
		// TODO Auto-generated method stub
		return hm;
	}

	public HashMap<String, Set<Employee>> getAllEmployeesByInsurance(String insurance) {
		// TODO Auto-generated method stub
		HashMap<String, Set<Employee>> resMap = new HashMap<String, Set<Employee>>();
		for(Entry<String, Set<Employee>> i : hm.entrySet()) {
			if(i.getKey().equals(insurance)) {
				resMap.put(i.getKey(), i.getValue());
			}
		}
		
		return resMap;
	}

	public List<Employee> deleteEmployee(int id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
