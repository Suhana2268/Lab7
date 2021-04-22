package com.cg.eis.pl;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.cg.eis.beans.Employee;
import com.cg.eis.service.EmployeeService;
import com.cg.eis.service.EmployeeServiceImpl;

public class MainUI {
	
	static Scanner sc = new Scanner(System.in);
	static EmployeeServiceImpl emps = new EmployeeServiceImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MainUI m = new MainUI();
		while(true) {
			System.out.println("Enter your choice: ");
			System.out.println("1. Enter employee"+"\n"+"2. Display employees"+"\n"+"3. Display Insurance Scheme"+"\n"+"0. Exit");
			int n = Integer.parseInt(sc.nextLine());
			switch(n) {
			case 1: 
				m.insertEmp();
				break;
			case 2:
				m.displayEmployees1();
				break;
			case 3:
				m.getEmpByInsurance();
				break;
			case 0:
				System.exit(0);
				
			}
			
		}


	}

	public static void insertEmp() {
		int id = Integer.parseInt(sc.nextLine());
		String name = sc.nextLine();
		String designation = sc.nextLine();
		int salary = Integer.parseInt(sc.nextLine());
		
		HashMap<String, Set<Employee>> hs = emps.insertEmployee(new Employee(id, name, designation, salary));
		//System.out.println(hs);
	}
	
	public  void getEmpByInsurance() {
		String insurance = sc.nextLine();
		HashMap<String, Set<Employee>> hs = emps.getAllEmployeesByInsurance(insurance);
		displayEmployees(hs);
	}
	
	public void getAllEmp() {
		HashMap<String, Set<Employee>>hs = emps.getAllEmployees();
		displayEmployees(hs);
	}
	
	
	public void displayEmployees(HashMap<String, Set<Employee>> hs) 
	{
		System.out.println("---------------Employee Information-----------------");
			print(hs);
		
		
	}
		
		public void displayEmployees1()
		{
			HashMap<String, Set<Employee>>hs = emps.getAllEmployees();
			
			displayEmployees(hs);
			
		}
		public void print(HashMap<String, Set<Employee>> hs) {
			for(Entry<String, Set<Employee>> i : hs.entrySet()) {
				System.out.println("Insurance scheme : "+i.getKey()+"\n"+"Employee details are: "+i.getValue());
				System.out.println();
			}
		}
		public Set<Employee> printSet(Set<Employee> se) {
			for(Employee e : se) {
				
				System.out.print("Name: "+e.getName()+" Id : "+ e.getId()+" Salary : "+e.getSalary()+" Designation : "+e.getDesignation());
				
			}
			return null;
		}
 }
