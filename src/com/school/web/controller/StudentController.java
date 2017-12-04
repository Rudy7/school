package com.school.web.controller;

import java.util.Scanner;
import com.school.web.bean.StudentBean;
import com.school.web.service.StudentService;
import com.school.web.serviceImpl.StudentServiceImpl;


public class StudentController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentBean student = null;
		System.out.println("학생수 입력");
		int count = scanner.nextInt();
		StudentService studentService = new StudentServiceImpl(count);
		
		while(true) {
			System.out.println("[메뉴] 0.정지 1.학생등록 2.성적등록 "
					           + "3.총 학생수 4.학생이름 리스트 5.내정보 보기 6.이름검색");
			switch(scanner.nextInt()) {
				case 0:
					System.out.println("시스템 종료");
					return;
				case 1:		
					student = new StudentBean();
					System.out.println("ID 입력");
					student.setId(scanner.next());
					System.out.println("PASS 입력");
					student.setPass(scanner.next());
					System.out.println("이름 입력");
					student.setName(scanner.next());
					studentService.addStudent(student);
					break;
				case 2:
					break;
				case 3:
					System.out.println("총 학생수는 " + studentService.getCount());
					break;
				case 4:
					StudentBean[] students = studentService.list();   //리턴하는게 집합체이다. members  그래서 앞에다 StudentBean[] 써준다. StudentBean[0]은 안된다.
					for(int i=0; i<students.length; i++) {
						System.out.println(students[i].getName()); 
					break;
					}
				case 5:
					String id = scanner.next();          //내가 만들지 않고, 알아서 만들라고 
					StudentBean temp = studentService.findStudentById(id);  //아이디 가지고 학생정보를 찾아줘 (id는 오픈된 정보라서)
					break;
				case 6:
					System.out.println("이름입력");
					String name = scanner.next();
					StudentBean[] studentc = studentService.findStudentByName(name);
//					.findStudentByName(scanner.next());
					if(student == null) {
						System.out.println("검색하려는 존재하지 않습니다.");
					}else {
						for(int i = 0; i<studentc.length; i++) {
							System.out.println(studentc[i].toString());   //getId()
						}
					}
					
					break;
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
		
		
		
	
	
	

