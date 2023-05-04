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
		mv.printEmployeeMenu(employee);
	}
	
	@Override
	public void checkEmployee() {
		mv.checkEmployeeMenu();
	}
	
	@Override
	public void insertEmployee() {
		Employee employee = mv.insertEmployeeMenu();
		int result = service.insertEmployee(employee);
		mv.printMsg(result > 0 ? "등록성공 :)" : "등록실패 :(");
	}
	
	@Override
	public void updateEmployee() {
		String employeeId = mv.findEmployeeMenu("수정");
		
		Employee employee = service.findEmployeeId(employeeId);
		
		mv.updateEmployeeMenu(employee);
	}
	
	@Override
	public void deleteEmployee() {
		String employeeId = mv.findEmployeeMenu("삭제");
		
		Employee employee = service.findEmployeeId(employeeId);
		
		char choice = mv.deleteEmployeeMenu(employee);
		
		if(choice == 'Y' || choice == 'y') {
			service.deleteEmployee(employeeId);
			mv.printMsg("삭제성공");
		} else if(choice == 'N' || choice == 'n') {
			mv.printMsg("===== 메인메뉴로 돌아갑니다. ======");
		}
	}
	@Override
	public void departmentMenu() {
		mv.departmentMenu();
		
	}
	@Override
	public void jobMenu() {
		// TODO Auto-generated method stub
		
	}
}
