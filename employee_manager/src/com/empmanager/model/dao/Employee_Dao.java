package com.empmanager.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.empmanager.model.dto.Employee;
import static com.empmanager.common.JDBCTemplete.close;;

public class Employee_Dao {
	private Properties prop = new Properties();
	
	{
		String path = Employee_Dao.class.getResource("/sql/employee_sql.properties").getPath();
		
		try(FileReader fr = new FileReader(path)){
			prop.load(fr);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Employee> checkAllEmployee(Connection conn) {
		String sql = prop.getProperty("checkAllEmployee");
		List<Employee> employee = new ArrayList<Employee>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				employee.add(getEmployee(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return employee;
	}
	
	public List<Employee> checkDeptCode(Connection conn, String deptCode) {
		String sql = prop.getProperty("checkDeptCode");
		List<Employee> employee = new ArrayList<Employee>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptCode.toUpperCase());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				employee.add(getEmployee(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return employee;
	}
	
	public List<Employee> checkJobCode(Connection conn, String jobCode) {
		String sql = prop.getProperty("checkJobCode");
		List<Employee> employee = new ArrayList<Employee>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jobCode.toUpperCase());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				employee.add(getEmployee(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return employee;
	}
	
	public List<Employee> checkEmployeeName(Connection conn, String employeeName) {
		String sql = prop.getProperty("checkEmployeeName");
		List<Employee> employee = new ArrayList<Employee>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%" + employeeName + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				employee.add(getEmployee(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return employee;
	}
	
	public List<Employee> checkSalary(Connection conn, int maxSalary, int minSalary) {
		String sql = prop.getProperty("checkSalary");
		List<Employee> employee = new ArrayList<Employee>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, minSalary);
			pstmt.setInt(2, maxSalary);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				employee.add(getEmployee(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return employee;
	}
	
	public int insertEmployee(Connection conn, Employee employee) {
		String sql = prop.getProperty("insertEmployee");
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employee.getEmp_Id());
			pstmt.setString(2, employee.getEmp_Name());
			pstmt.setString(3, employee.getEmp_No());
			pstmt.setString(4, employee.getEmail());
			pstmt.setString(5, employee.getPhone());
			pstmt.setString(6, employee.getDept_Code());
			pstmt.setString(7, employee.getJob_Code());
			pstmt.setString(8, employee.getSal_Level());
			pstmt.setInt(9, employee.getSalary());
			pstmt.setDouble(10, employee.getBonus());
			pstmt.setString(11, employee.getManager_Id());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public Employee findEmployeeId(Connection conn, String employeeId) {
		String sql = prop.getProperty("findEmployeeId");
		Employee employee = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employeeId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) employee = getEmployee(rs);
			else return employee;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return employee;
	}
	
	public int updateDeptCode(Connection conn, String employeeId, String deptCode) {
		String sql = prop.getProperty("updateDeptCode");
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptCode);
			pstmt.setString(2, employeeId);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public int updateJobCode(Connection conn, String employeeId, String jobCode) {
		String sql = prop.getProperty("updateJobCode");
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jobCode);
			pstmt.setString(2, employeeId);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public int updateSalary(Connection conn, String employeeId, int salary) {
		String sql = prop.getProperty("updateSalary");
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, salary);
			pstmt.setString(2, employeeId);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public int updatePhoneNum(Connection conn, String employeeId, String phoneNum) {
		String sql = prop.getProperty("updatePhoneNum");
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phoneNum);
			pstmt.setString(2, employeeId);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public int updateEmail(Connection conn, String employeeId, String email) {
		String sql = prop.getProperty("updateEmail");
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, employeeId);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public int deleteEmployee(Connection conn, String employeeId) {
		String sql = prop.getProperty("deleteEmployee");
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employeeId);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public int insertDepartment(Connection conn, String deptId, String deptTitle, String locationCode) {
		String sql = prop.getProperty("insertDepartment");
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptId);
			pstmt.setString(2, deptTitle);
			pstmt.setString(3, locationCode);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	private Employee getEmployee(ResultSet rs) throws SQLException {
		Employee e = new Employee();
		e.setEmp_Id(rs.getString("EMP_ID"));
		e.setEmp_Name(rs.getString("EMP_NAME"));
		e.setEmp_No(rs.getString("EMP_NO"));
		e.setEmail(rs.getString("EMAIL"));
		e.setPhone(rs.getString("PHONE"));
		e.setDept_Code(rs.getString("DEPT_CODE"));
		e.setJob_Code(rs.getString("JOB_CODE"));
		e.setSal_Level(rs.getString("SAL_LEVEL"));
		e.setSalary(rs.getInt("SALARY"));
		e.setBonus(rs.getDouble("BONUS"));
		e.setManager_Id(rs.getString("MANAGER_ID"));
		e.setHire_Date(rs.getDate("HIRE_DATE"));
		e.setEnt_Date(rs.getDate("ENT_DATE"));
		e.setEnt_YN(rs.getString("ENT_YN").charAt(0));
		return e;
	}
}
