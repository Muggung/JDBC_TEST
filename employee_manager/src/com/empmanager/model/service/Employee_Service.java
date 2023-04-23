package com.empmanager.model.service;

import static com.empmanager.common.JDBCTemplete.getConnection;
import static com.empmanager.common.JDBCTemplete.close;

import java.sql.Connection;
import java.util.List;

import com.empmanager.model.dao.Employee_Dao;
import com.empmanager.model.dto.Employee;

public class Employee_Service {
	Employee_Dao dao = new Employee_Dao();
	
	public List<Employee> checkAllEmployee() {
		Connection conn = getConnection();
		List<Employee> employee = dao.checkAllEmployee(conn);
		close(conn);
		return employee;
	}
}
