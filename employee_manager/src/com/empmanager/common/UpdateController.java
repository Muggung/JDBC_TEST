package com.empmanager.common;


public interface UpdateController {
	void updateDeptCode(String empId, String deptCode);
	void updateJobCode(String empId, String jobCode);
	void updateSalary(String empId, int salary);
	void updatePhoneNum(String empId, String phoneNum);
	void updateEmail(String empId, String email);
}
