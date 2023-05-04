package com.empmanager.controller;

import com.empmanager.common.DepartmentMenu;
import com.empmanager.model.service.EmployeeService;
import com.empmanager.view.MainView;

public class DepartmentController implements DepartmentMenu {
	private static DepartmentController departmentController = new DepartmentController();
	private DepartmentController(){};
	public static DepartmentController getDepartmentController() {
		return departmentController;
	}
	
	MainView mv = new MainView();
	EmployeeService service = new EmployeeService();
	
	@Override
	public void insertDepartment(String deptId, String deptTitle, String locationCode) {
		int result = service.insertDepartment(deptId, deptTitle, locationCode);
		mv.printMsg(result > 0 ? "등록 성공 :)" : "등록 실패 :(");
	}

	@Override
	public void UpdateDepartment(String departCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteDepartment() {
		// TODO Auto-generated method stub
		
	}

}
