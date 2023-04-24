package com.empmanager.common;

public interface SubController {
	void checkDeptCode(String deptCode);
	void checkJobCode(String jobCode);
	void checkEmployeeName(String name);
	void checkSalary(int maxSalary, int minSalary);
}
