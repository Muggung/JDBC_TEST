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
	public void updateJobCode(String deptId, String jobCode) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateSalary(String deptId, int salary) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updatePhone(String deptId, String phone) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateEmail(String deptId, String email) {
		// TODO Auto-generated method stub
		
	}
	


}
