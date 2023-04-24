package com.empmanager.controller;

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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateEmployee() {
		// TODO Auto-generated method stub
		
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
