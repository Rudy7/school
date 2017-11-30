package com.school.web.controller;

import java.util.Scanner;

import com.school.web.bean.TeacherBean;

public class TeacherController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TeacherBean teacherBean = new TeacherBean();
		
		System.out.println("Id");
		teacherBean.setId(scanner.next());
		System.out.println("Pass");
		teacherBean.setPass(scanner.next());
		System.out.println("Name");
		teacherBean.setName(scanner.next());
		System.out.println("Subject");
		teacherBean.setSubject(scanner.next());
		
		
	}
	
		
	}
	

