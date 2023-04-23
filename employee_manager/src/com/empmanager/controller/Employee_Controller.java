package com.empmanager.controller;

import java.util.List;

import com.empmanager.common.MainController;
import com.empmanager.model.dto.Employee;
import com.empmanager.model.service.Employee_Service;
import com.empmanager.view.MainView;

public class Employee_Controller implements MainController{
	private static Employee_Controller controller = new Employee_Controller();
	private Employee_Controller(){};
	public static Employee_Controller getController() {
		return controller;
	}
	
	MainView mv = new MainView();
	Employee_Service service = new Employee_Service();
	
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
		// TODO Auto-generated method stub
		
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
