package com.empmanager.controller;

import com.empmanager.common.UpdateController;

public class UpdateEmployeeController implements UpdateController{
	private static UpdateEmployeeController updateController = new UpdateEmployeeController();
	private UpdateEmployeeController() {};
	public static UpdateController getUpdateController() {
		return updateController;
	}
	
	@Override
	public void updateDeptCode() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateJobCode() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSalary() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePhone() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmail() {
		// TODO Auto-generated method stub
		
	}
	
}
