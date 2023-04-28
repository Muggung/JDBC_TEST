package com.empmanager.controller;

import com.empmanager.common.UpdateController;
import com.empmanager.model.service.EmployeeService;
import com.empmanager.view.MainView;

public class UpdateEmployeeController implements UpdateController{
	private static UpdateEmployeeController updateController = new UpdateEmployeeController();
	private UpdateEmployeeController() {};
	public static UpdateController getUpdateController() {
		return updateController;
	}
	
	EmployeeService service = new EmployeeService();
	MainView mv = new MainView();
	
	@Override
	public void updateDeptCode(String employeeId, String deptCode) {
		int result = service.updateDeptCode(employeeId, deptCode);
		
		mv.printMsg(result > 0 ? "수정 성공 :)" : "수정 실패 :(");
	}
	@Override
	public void updateJobCode(String employeeId, String jobCode) {
		int result = service.updateJobCode(employeeId, jobCode);
		
		mv.printMsg(result > 0 ? "수정 성공 :)" : "수정 실패 :(");
	}
	@Override
	public void updateSalary(String employeeId, int salary) {
		int result = service.updateSalary(employeeId, salary);
		
		mv.printMsg(result > 0 ? "수정 성공 :)" : "수정 실패 :(");
	}
	@Override
	public void updatePhoneNum(String employeeId, String phoneNum) {
		int result = service.updatePhoneNum(employeeId, phoneNum);
		
		mv.printMsg(result > 0 ? "수정 성공 :)" : "수정 실패 :(");
	}
	@Override
	public void updateEmail(String employeeId, String email) {
		int result = service.updateEmail(employeeId, email);
		
		mv.printMsg(result > 0 ? "수정 성공 :)" : "수정 실패 :(");
	}
	


}
