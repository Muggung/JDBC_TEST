package com.empmanager.common;

public interface DepartmentMenu {
	void insertDepartment(String departCode, String departTitle, String locationCode);
	void UpdateDepartment(String departCode);
	void DeleteDepartment();
}
