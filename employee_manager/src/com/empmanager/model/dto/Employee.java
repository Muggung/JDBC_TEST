package com.empmanager.model.dto;

import java.sql.Date;
import java.util.Objects;

public class Employee {
	private String emp_Id;
	private String emp_Name;
	private String emp_No;
	private String email;
	private String phone;
	private String dept_Code;
	private String job_Code;
	private String sal_Level;
	private int salary;
	private double bonus;
	private String manager_Id;
	private Date hire_Date;
	private Date ent_Date;
	private char ent_YN;
	
	public Employee() {}

	public Employee(String emp_Id, String emp_Name, String emp_No, String email, String phone, String dept_Code,
			String job_Code, String sal_Level, int salary, double bonus, String manager_Id, Date hire_Date,
			Date ent_Date, char ent_YN) {
		super();
		this.emp_Id = emp_Id;
		this.emp_Name = emp_Name;
		this.emp_No = emp_No;
		this.email = email;
		this.phone = phone;
		this.dept_Code = dept_Code;
		this.job_Code = job_Code;
		this.sal_Level = sal_Level;
		this.salary = salary;
		this.bonus = bonus;
		this.manager_Id = manager_Id;
		this.hire_Date = hire_Date;
		this.ent_Date = ent_Date;
		this.ent_YN = ent_YN;
	}

	public String getEmp_Id() {
		return emp_Id;
	}

	public void setEmp_Id(String emp_Id) {
		this.emp_Id = emp_Id;
	}

	public String getEmp_Name() {
		return emp_Name;
	}

	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}

	public String getEmp_No() {
		return emp_No;
	}

	public void setEmp_No(String emp_No) {
		this.emp_No = emp_No;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDept_Code() {
		return dept_Code;
	}

	public void setDept_Code(String dept_Code) {
		this.dept_Code = dept_Code;
	}

	public String getJob_Code() {
		return job_Code;
	}

	public void setJob_Code(String job_Code) {
		this.job_Code = job_Code;
	}

	public String getSal_Level() {
		return sal_Level;
	}

	public void setSal_Level(String sal_Level) {
		this.sal_Level = sal_Level;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public String getManager_Id() {
		return manager_Id;
	}

	public void setManager_Id(String manager_Id) {
		this.manager_Id = manager_Id;
	}

	public Date getHire_Date() {
		return hire_Date;
	}

	public void setHire_Date(Date hire_Date) {
		this.hire_Date = hire_Date;
	}

	public Date getEnt_Date() {
		return ent_Date;
	}

	public void setEnt_Date(Date ent_Date) {
		this.ent_Date = ent_Date;
	}

	public char getEnt_YN() {
		return ent_YN;
	}

	public void setEnt_YN(char ent_YN) {
		this.ent_YN = ent_YN;
	}

	@Override
	public String toString() {
		return "Employee [emp_Id=" + emp_Id + ", emp_Name=" + emp_Name + ", emp_No=" + emp_No + ", email=" + email
				+ ", phone=" + phone + ", dept_Code=" + dept_Code + ", job_Code=" + job_Code + ", sal_Level="
				+ sal_Level + ", salary=" + salary + ", bonus=" + bonus + ", manager_Id=" + manager_Id + ", hire_Date="
				+ hire_Date + ", ent_Date=" + ent_Date + ", ent_YN=" + ent_YN + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bonus, dept_Code, email, emp_Id, emp_Name, emp_No, ent_Date, ent_YN, hire_Date, job_Code,
				manager_Id, phone, sal_Level, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Double.doubleToLongBits(bonus) == Double.doubleToLongBits(other.bonus)
				&& Objects.equals(dept_Code, other.dept_Code) && Objects.equals(email, other.email)
				&& Objects.equals(emp_Id, other.emp_Id) && Objects.equals(emp_Name, other.emp_Name)
				&& Objects.equals(emp_No, other.emp_No) && Objects.equals(ent_Date, other.ent_Date)
				&& ent_YN == other.ent_YN && Objects.equals(hire_Date, other.hire_Date)
				&& Objects.equals(job_Code, other.job_Code) && Objects.equals(manager_Id, other.manager_Id)
				&& Objects.equals(phone, other.phone) && Objects.equals(sal_Level, other.sal_Level)
				&& salary == other.salary;
	}
}
