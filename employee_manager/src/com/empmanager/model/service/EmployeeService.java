package com.empmanager.model.service;

import static com.empmanager.common.JDBCTemplete.close;
import static com.empmanager.common.JDBCTemplete.commit;
import static com.empmanager.common.JDBCTemplete.getConnection;
import static com.empmanager.common.JDBCTemplete.rollback;

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
	
	public List<Employee> checkEmployeeName(String employeeName) {
		Connection conn = getConnection();
		List<Employee> employee = dao.checkEmployeeName(conn, employeeName);
		close(conn);
		return employee;
	}
	
	public List<Employee> checkSalary(int maxSalary, int minSalary) {
		Connection conn = getConnection();
		List<Employee> employee = dao.checkSalary(conn, maxSalary, minSalary);
		close(conn);
		return employee;
	}
	
	public int insertEmployee(Employee employee) {
		Connection conn = getConnection();
		int result = dao.insertEmployee(conn, employee);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public Employee findEmployeeId(String employeeId) {
		Connection conn = getConnection();
		Employee employee = dao.findEmployeeId(conn, employeeId);
		close(conn);
		return employee;
	}
	
	public int updateDeptCode(String employeeId, String deptCode) {
		Connection conn = getConnection();
		int result = dao.updateDeptCode(conn, employeeId, deptCode);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int updateJobCode(String employeeId, String jobCode) {
		Connection conn = getConnection();
		int result = dao.updateJobCode(conn, employeeId, jobCode);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int updateSalary(String employeeId, int salary) {
		Connection conn = getConnection();
		int result = dao.updateSalary(conn, employeeId, salary);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int updatePhoneNum(String employeeId, String phoneNum) {
		Connection conn = getConnection();
		int result = dao.updatePhoneNum(conn, employeeId, phoneNum);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int updateEmail(String employeeId, String email) {
		Connection conn = getConnection();
		int result = dao.updateEmail(conn, employeeId, email);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int deleteEmployee(String employeeId) {
		Connection conn = getConnection();
		int result = dao.deleteEmployee(conn, employeeId);
		if(result > 0) commit(conn);
		else rollback(conn);
		return result;
	}
	
	public int insertDepartment(String deptId, String deptTitle, String locationCode) {
		Connection conn = getConnection();
		int result = dao.insertDepartment(conn, deptId, deptTitle, locationCode);
		if(result > 0) commit(conn);
		else rollback(conn);
		return result;
	}
}
