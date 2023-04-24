package com.empmanager.model.service;

import static com.empmanager.common.JDBCTemplete.getConnection;
import static com.empmanager.common.JDBCTemplete.close;

import java.sql.Connection;
import java.util.List;

import com.empmanager.model.dao.Employee_Dao;
import com.empmanager.model.dto.Employee;

public class EmployeeService {
	Employee_Dao dao = new Employee_Dao();
	
	public List<Employee> checkAllEmployee() {
		Connection conn = getConnection();
		List<Employee> employee = dao.checkAllEmployee(conn);
		close(conn);
		return employee;
	}
	
	public List<Employee> checkDeptCode(String deptCode) {
		Connection conn = getConnection();
		List<Employee> employee = dao.checkDeptCode(conn, deptCode);
		close(conn);
		return employee;
	}
	
	public List<Employee> checkJobCode(String jobCode) {
		Connection conn = getConnection();
		List<Employee> employee = dao.checkJobCode(conn, jobCode);
		close(conn);
		return employee;
	}
	
	public List<Employee> checkEmployeeName(String name) {
		Connection conn = getConnection();
		List<Employee> employee = dao.checkEmployeeName(conn, name);
		close(conn);
		return employee;
	}
	
	public List<Employee> checkSalary(int maxSalary, int minSalary) {
		Connection conn = getConnection();
		List<Employee> employee = dao.checkSalary(conn, maxSalary, minSalary);
		close(conn);
		return employee;
	}
}
