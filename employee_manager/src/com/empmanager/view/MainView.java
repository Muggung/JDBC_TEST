package com.empmanager.view;

import java.util.List;
import java.util.Scanner;

import com.empmanager.controller.Employee_Controller;
import com.empmanager.model.dto.Employee;

public class MainView {
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		while(true) {
			System.out.println("===== 사원 관리 프로그램 =====");
			System.out.println("1. 전체 사원 조회");
			System.out.println("2. 사원 조회 (부서, 직책, 이름, 급여)");
			System.out.println("3. 사원 등록");
			System.out.println("4. 사원 수정 (직책, 부서, 급여, 전화번호, 이메일)");
			System.out.println("5. 사원 삭제");
			System.out.println("6. 부서 관리 메뉴");
			System.out.println("7. 직책 관리 메뉴");
			System.out.println("0. 프로그램 종료");
			System.out.print("입력 : ");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1 : Employee_Controller.getController().checkAllEmployee(); break;
				case 2 : Employee_Controller.getController().checkEmployee(); break;
				case 3 : Employee_Controller.getController().insertEmployee(); break;
				case 4 : Employee_Controller.getController().updateEmployee(); break;
				case 5 : Employee_Controller.getController().deleteEmployee(); break;
				case 6 : Employee_Controller.getController().departmentMenu(); break;
				case 7 : Employee_Controller.getController().jobMenu(); break;
				case 0 : System.out.println("===== 프로그램 종료 ====="); return;
				default : System.out.println("메뉴에 있는 번호를 입력해주세요."); break;
			}
		}
	}
	
	public void printEmployee(List<Employee> employee) {
		System.out.println("===== 사원 조회 =====");
		employee.forEach(e -> System.out.println(e));
		System.out.println("==================");
	}
}
