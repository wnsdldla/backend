package com.backend.demo.DAO;

import org.springframework.stereotype.Repository;

import com.backend.demo.VO.Employee;
import com.backend.demo.VO.Employees;

@Repository
public class PracticeDAO {

	private static Employees list = new Employees();
	
	static {
		list.getEmployeeList().add(new Employee(1,"Lokesh","Gupta","howtodoinjava@naver.com"));
		list.getEmployeeList().add(new Employee(2,"Alex","Kolenchiskey","abc@naver.com"));
		list.getEmployeeList().add(new Employee(3,"David","kameron","titanic@naver.com"));
	}
	
	public Employees getAllEmployees() {
		return list;
	}
	
	public void addEmployees(Employee employee) {
		list.getEmployeeList().add(employee);
	}
	
}
