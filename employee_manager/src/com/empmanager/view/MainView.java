package com.empmanager.view;

import static com.empmanager.controller.EmployeeController.getController;
import static com.empmanager.controller.EmployeeSubController.getSubController;
import static com.empmanager.controller.UpdateEmployeeController.getUpdateController;
import static com.empmanager.controller.DepartmentController.getDepartmentController;

import java.util.List;
import java.util.Scanner;

import com.empmanager.model.dto.Employee;

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
	
	public void printMsg(String systemMessege) {
		System.out.println("===== 시스템 메세지 =====");
		System.out.println(systemMessege);
	}
	
	public void printEmployeeMenu(List<Employee> employee) {
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
	
	public Employee insertEmployeeMenu(){
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
	
	public String findEmployeeMenu(String menuName) {
		System.out.println("===== " + menuName + "할 사원 아이디 입력 =====");
		System.out.print("사원 아이디 입력 : ");
		return sc.next();
	}
	
	public void updateEmployeeMenu(Employee employee) {
		if(employee == null) {
			System.out.println("조회된 회원이 없습니다.");
			return;
		}
		
		while(true) {
			System.out.println("===== "+ employee.getEmp_Id() + " " + employee.getEmp_Name() + "님 사원 정보 수정 =====");
			System.out.println("1. 부서 코드 수정");
			System.out.println("2. 직책 코드 수정");
			System.out.println("3. 급여 금액 수정");
			System.out.println("4. 전화번호 수정");
			System.out.println("5. 이메일 수정");
			System.out.println("0. 메인 메뉴 돌아가기");
			System.out.print("입력 : ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
				case 1 :
					System.out.print("수정할 부서 코드 : ");
					getUpdateController().updateDeptCode(employee.getEmp_Id(), sc.nextLine()); break;
				case 2 :
					System.out.print("수정할 직책 코드 : ");
					getUpdateController().updateJobCode(employee.getEmp_Id(), sc.nextLine()); break;
				case 3 : 
					System.out.print("수정할 급여 금액 : ");
					getUpdateController().updateSalary(employee.getEmp_Id(), sc.nextInt()); break;
				case 4 : 
					System.out.print("수정할 전화번호 : ");
					getUpdateController().updatePhoneNum(employee.getEmp_Id(), sc.nextLine()); break;
				case 5 : 
					System.out.print("수정할 이메일 주소 : ");
					getUpdateController().updateEmail(employee.getEmp_Id(), sc.nextLine()); break;
				case 0 : return;
				default : System.out.println("메뉴에 있는 번호를 입력해주세요."); break;
			}
		}
	}
	
	public char deleteEmployeeMenu(Employee employee) {
		System.out.println("===== 삭제 메뉴 =====");
		char choice = ' ';
		while(true) {
			System.out.println("사원번호 " + employee.getEmp_Id() + "번 " + employee.getEmp_Name() + "님의 정보를 정말 삭제합니까??");
			System.out.print("입력(Y/N) : ");
			choice = sc.next().charAt(0);
			
			if(choice == 'Y' || choice == 'y' || choice == 'N' || choice == 'n') {
				break;
			}
			System.out.println("Y 또는 N을 입력해주세요.");
		} return choice;
	}
	
	public void departmentMenu() {
		String deptCode = null;
		String deptTitle = null;
		
		while(true) {
			System.out.println("===== 부서관리 메뉴 =====");
			System.out.println("1. 부서 등록");
			System.out.println("2. 부서 수정");
			System.out.println("3. 부서 삭제");
			System.out.println("0. 메인메뉴로 돌아가기");
			System.out.print("입력 : ");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1 :
					System.out.print("등록할 부서 코드 : ");
					deptCode = sc.next();
					System.out.print("등록할 부서의 부서명 : ");
					sc.nextLine();
					deptTitle = sc.nextLine();
					System.out.print("등록할 부서의 지역코드 : ");
					String locationCode = sc.next();
					getDepartmentController().insertDepartment(deptCode, deptTitle, locationCode); break;
				case 2 : System.out.println("개발 중"); break;
//					System.out.println("수정할 부서코드 : ");
//					deptCode = sc.next();
//					getDepartmentController().UpdateDepartment(deptCode); break;
				case 3 : System.out.println("개발 중"); break;
				case 0 : return;
					
			}
		}
	}
}
