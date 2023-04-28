package com.empmanager.view;

import java.util.List;
import java.util.Scanner;

import com.empmanager.model.dto.Employee;

import static com.empmanager.controller.EmployeeController.getController;
import static com.empmanager.controller.EmployeeSubController.getSubController;
import static com.empmanager.controller.UpdateEmployeeController.getUpdateController;

public class MainView {
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		while(true) {
			System.out.println("===== 사원 관리 프로그램 =====");
			System.out.println("1. 전체 사원 조회");
			System.out.println("2. 사원 조회 (부서, 직책, 이름, 급여)");
			System.out.println("3. 사원 등록");
			System.out.println("4. 사원 수정 (부서, 직책, 급여, 전화번호, 이메일)");
			System.out.println("5. 사원 삭제");
			System.out.println("6. 부서 관리 메뉴");
			System.out.println("7. 직책 관리 메뉴");
			System.out.println("0. 프로그램 종료");
			System.out.print("입력 : ");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1 : getController().checkAllEmployee(); break;
				case 2 : getController().checkEmployee(); break;
				case 3 : getController().insertEmployee(); break;
				case 4 : getController().updateEmployee(); break;
				case 5 : getController().deleteEmployee(); break;
				case 6 : getController().departmentMenu(); break;
				case 7 : getController().jobMenu(); break;
				case 0 : System.out.println("===== 프로그램 종료 ====="); return;
				default : System.out.println("메뉴에 있는 번호를 입력해주세요."); break;
			}
		}
	}
	
	public void printMsg(String msg) {
		System.out.println("===== 시스템 메세지 =====");
		System.out.println(msg);
	}
	
	public void printEmployee(List<Employee> employee) {
		System.out.println("===== 사원 조회 =====");
		if(employee.isEmpty()) {
			System.out.println("===== 조회된 사원이 없습니다 :( =====");
		}else if(!employee.isEmpty()) {
			employee.forEach(e -> System.out.println(e));
			System.out.println("==================");
		}
	}
	
	public void checkEmployeeMenu() {
		while(true) {
			System.out.println("===== 사원 조회 메뉴 =====");
			System.out.println("1. 부서 코드 조회");
			System.out.println("2. 직책 코드 조회");
			System.out.println("3. 사원 이름 조회");
			System.out.println("4. 급여 범위 조회");
			System.out.println("0. 메인 메뉴 돌아가기");
			System.out.print("입력 : ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
				case 1 :
					System.out.print("부서 코드 입력 : ");
					getSubController().checkDeptCode(sc.nextLine()); break;
				case 2 : 
					System.out.print("직책 코드 입력 : ");
					getSubController().checkJobCode(sc.nextLine()); break;
				case 3 : 
					System.out.print("사원 이름 입력 : ");
					getSubController().checkEmployeeName(sc.nextLine()); break;
				case 4 : 
					System.out.print("최대 급여 : ");
					int maxSalary = sc.nextInt();
					System.out.print("최소 급여 : ");
					int minSalary = sc.nextInt();
					getSubController().checkSalary(maxSalary, minSalary); break;
				case 0 : return;
				default : System.out.println("메뉴에 있는 번호를 입력해주세요.");
			}
		}
	}
	
	public Employee insertEmployee(){
		Employee e = new Employee();
		
		System.out.println("===== 사원 등록 =====");
		sc.nextLine();
		System.out.print("사원 아이디 : ");
		e.setEmp_Id(sc.nextLine());
		System.out.print("사원 이름 : ");
		e.setEmp_Name(sc.nextLine());
		System.out.print("주민 번호 : ");
		e.setEmp_No(sc.nextLine());
		System.out.print("이메일 : ");
		e.setEmail(sc.nextLine());
		System.out.print("휴대폰 : ");
		e.setPhone(sc.nextLine());
		System.out.print("부서 코드 : ");
		e.setDept_Code(sc.nextLine());
		System.out.print("직책 코드 : ");
		e.setJob_Code(sc.nextLine());
		System.out.print("급여 등급 : ");
		e.setSal_Level(sc.nextLine());
		System.out.print("급여 : ");
		e.setSalary(sc.nextInt());
		System.out.print("보너스 : ");
		e.setBonus(sc.nextDouble());
		sc.nextLine();
		System.out.print("관리자 사번 : ");
		e.setManager_Id(sc.nextLine());
		return e;
	}
	
	public String findEmployee(String menuName) {
		System.out.println("===== " + menuName + "할 사원 아이디 입력 =====");
		System.out.print("사원 아이디 입력 : ");
		String empId = sc.next();
		return empId;
	}
	
	public void updateEmployeeMenu(Employee e) {
		if(e == null) {
			System.out.println("조회된 회원이 없습니다.");
			return;
		}
		
		while(true) {
			System.out.println("===== "+ e.getEmp_Id() + " " + e.getEmp_Name() + "님 사원 정보 수정 =====");
			System.out.println("1. 부서 코드 수정");
			System.out.println("2. 직책 코드 수정");
			System.out.println("3. 급여 금액 수정");
			System.out.println("4. 전화번호 수정");
			System.out.println("5. 이메일 주소 수정");
			System.out.println("0. 메인 메뉴 돌아가기");
			System.out.print("입력 : ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
				case 1 :
					System.out.print("수정할 부서 코드 : ");
					getUpdateController().updateDeptCode(e.getEmp_Id(), sc.nextLine()); break;
				case 2 :
					System.out.print("수정할 직책 코드 : ");
					getUpdateController().updateJobCode(e.getEmp_Id(), sc.nextLine()); break;
				case 3 : 
					System.out.print("수정할 급여 금액 : ");
					getUpdateController().updateSalary(e.getEmp_Id(), sc.nextInt()); break;
				case 4 : 
					System.out.print("수정할 전화번호 : ");
					getUpdateController().updatePhoneNum(e.getEmp_Id(), sc.nextLine()); break;
				case 5 : 
					System.out.print("수정할 이메일 주소 : ");
					getUpdateController().updateEmail(e.getEmp_Id(), sc.nextLine()); break;
				case 0 : return;
				default : System.out.println("메뉴에 있는 번호를 입력해주세요."); break;
			}
		}
	}
}
