package com.empmanager.controller;

import java.util.List;

import com.empmanager.common.SubController;
import com.empmanager.model.dto.Employee;
import com.empmanager.model.service.EmployeeService;
import com.empmanager.view.MainView;

public class EmployeeSubController implements SubController{
	private static EmployeeSubController esc = new EmployeeSubController();
	private EmployeeSubController() {};
	public static EmployeeSubController getSubController() {
		return esc;
	}
	
	EmployeeService service = new EmployeeService();
	MainView mv = new MainView();
	
	@Override
	public void checkDeptCode(String deptCode) {
		List<Employee> employee = service.checkDeptCode(deptCode);
		mv.printEmployee(employee);
	}
	@Override
	public void checkJobCode(String jobCode) {
		List<Employee> employee = service.checkJobCode(jobCode);
		mv.printEmployee(employee);
	}
	@Override
	public void checkEmployeeName(String name) {
		List<Employee> employee = service.checkEmployeeName(name);
		mv.printEmployee(employee);
	}
	@Override
	public void checkSalary(int maxSalary, int minSalary) {
		List<Employee> employee = service.checkSalary(maxSalary, minSalary);
		mv.printEmployee(employee);
	}
}
