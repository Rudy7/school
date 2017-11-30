package com.school.web.controller;

import java.util.Scanner;
import com.school.web.bean.StudentBean;
import com.school.web.service.StudentService;
import com.school.web.serviceImpl.StudentServiceImpl;


public class StudentController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentService studentService = new StudentServiceImpl();
		StudentBean student = new StudentBean();
		while(true) {
			System.out.println("[메뉴] 0.정지 1.학생등록 2.성적등록 ");
			switch(scanner.nextInt()) {
				case 0:
					System.out.println("시스템 종료");
					return;
				case 1:
					System.out.println("ID 입력");
					student.setId(scanner.next());
					System.out.println("PASS 입력");
					student.setPass(scanner.next());
					System.out.println("이름 입력");
					student.setName(scanner.next());
					studentService.addStudent(student);
			}		
		}			
	}
}
		
		
//		System.out.println("Id");
//		studentBean.setId(scanner.next());
//		System.out.println("Pass");
//		studentBean.setPass(scanner.next());
//		System.out.println("Name");
//		studentBean.setName(scanner.next());
//		System.out.println("Kor");
//		studentBean.setKor(scanner.nextInt());
//		System.out.println("Eng");
//		studentBean.setEng(scanner.nextInt());
//		System.out.println("Math");
//		studentBean.setMath(scanner.nextInt());
		
		
		
	
	
	

