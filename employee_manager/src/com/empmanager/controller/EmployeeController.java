package com.empmanager.controller;

import java.text.ParseException;
import java.util.List;

import com.empmanager.common.MainController;
import com.empmanager.model.dto.Employee;
import com.empmanager.model.service.EmployeeService;
import com.empmanager.view.MainView;

public class EmployeeController implements MainController{
	private static EmployeeController controller = new EmployeeController();
	private EmployeeController(){};
	public static EmployeeController getController() {
		return controller;
	}
	
	MainView mv = new MainView();
	EmployeeService service = new EmployeeService();
	
	@Override
	public void startProgram() {
		mv.mainMenu();
	}
	
	@Override
	public void checkAllEmployee() {
		List<Employee> employee = service.checkAllEmployee();
		mv.printEmployee(employee);
	}
	@Override
	public void checkEmployee() {
		mv.checkEmployeeMenu();
	}
	@Override
	public void insertEmployee() {
		Employee employee = mv.insertEmployee();
		int result = service.insertEmployee(employee);
		mv.printMsg(result > 0 ? "등록성공 :)" : "등록실패 :(");
	}
	
	@Override
	public void updateEmployee() {
		String employeeId = mv.findEmployee("수정");
		
		Employee employee = service.findEmployeeId(employeeId);
		
		mv.updateEmployeeMenu(employee);
	}
	
	@Override
	public void deleteEmployee() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void departmentMenu() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void jobMenu() {
		// TODO Auto-generated method stub
		
	}
}
