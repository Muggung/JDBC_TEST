package com.empmanager.common;

import com.empmanager.model.dto.Employee;

public interface UpdateController {
	void updateDeptCode(String deptId, String deptCode);
	void updateJobCode(String deptId, String jobCode);
	void updateSalary(String deptId, int salary);
	void updatePhone(String deptId, String phone);
	void updateEmail(String deptId, String email);
}
