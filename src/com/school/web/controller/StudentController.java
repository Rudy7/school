package com.school.web.controller;

import java.util.Scanner;
import javax.swing.JOptionPane;
import com.school.web.bean.StudentBean;
import com.school.web.service.StudentService;
import com.school.web.serviceImpl.StudentServiceImpl;
import com.school.web.ui.MainPage;

public class StudentController {
	public static void main(String[] args) {

		// String sCount = JOptionPane.showInputDialog("학생수 입력");
		// int count = Integer.parseInt(sCount);
		// StudentService studentService = new StudentServiceImpl(count); 이세줄과 하단 4줄은
		// 같은것이다. 정리
		// sCount 와 count가 중복되서 정리된다.
		 //배열 초기화를 위해서. 학생 배열만들려고. (학생수 늘릴려고.)
		StudentService studentService = new StudentServiceImpl();
		StudentBean student = null;
		StudentBean[] students = null;
		StudentBean[] studentc = null;
		String message = "";
		while (true) {
			switch (JOptionPane
					.showInputDialog(
							"[메뉴] 0.정지\n"
							+ "1.학생등록 2.성적등록" + " 3.총 학생수\n"
							+ "4.학생이름 리스트 5.내정보 보기 6.이름검색\n" 
							+ "7.비번변경 8.삭제 9.화면보기")) {
			case "0":
//				System.out.println("시스템 종료");								이줄을 아래로 변경한다. 
				JOptionPane.showMessageDialog(null, "시스템 종료");
				return;
			case "1":
				student = new StudentBean();
				student.setId(JOptionPane.showInputDialog("ID 입력"));
				student.setPass(JOptionPane.showInputDialog("PASS 입력"));
				student.setName(JOptionPane.showInputDialog("이름 입력"));
				studentService.addStudent(student);
				JOptionPane.showMessageDialog(null, "등록완료");
				break;
			case "2":
				break;
			case "3":
			JOptionPane.showMessageDialog(null, 
							"총 학생수는 " 
									+ studentService.getCount());
				break;
			case "4":
				message = "";
//				StudentBean[] students = new StudentBean[studentService.getCount()];
				students = studentService.list(); // 리턴하는게 집합체이다. members 그래서 앞에다 StudentBean[] 써준다.
																// StudentBean[0]은 안된다.
				for (int i = 0; i < studentService.getCount(); i++) {
					message += students[i].getName()+"\n";
				}
				JOptionPane.showMessageDialog(null, message);
				break;
			case "5":
				StudentBean temp = studentService.findStudentById(JOptionPane.showInputDialog("아이디 주셈")); // 아이디 가지고 학생정보를 찾아줘 (id는 오픈된 정보라서)
				break;
			case "6":
				message = "";
				String name = JOptionPane.showInputDialog("이름입력");
				studentc = studentService.findStudentByName(name);
				// .findStudentByName(scanner.next());
				if (student == null) {
					System.out.println("검색하려는 값이 존재하지 않습니다.");

				} else {
					for (int i = 0; i < studentc.length; i++) {
						message = studentc[i].toString(); // getId()
					}
				}
				JOptionPane.showMessageDialog(null, message);
				break;
			case "7":
				student = new StudentBean();
				// 전달할려는 녀석에 파람(param 파라미터)이라고 많이 쓴다.

				student.setId(JOptionPane.showInputDialog("수정하고자 하는 비번의 ID")); // 아이디를 입력받아서
				student.setPass(JOptionPane.showInputDialog("변경하실 비번을 입력하세요."));
				studentService.updatePassword(student);

				// studentService.updatePassword(paramId); 그 아이디를 가지고 비번을 변경하자 . 임플에 던지고,
				// StudentBean resStudent = studentService.findStudentById(paramId); 그아이디를가지고
				// 아이디를찾아서 res스튜던트라고 하자
				JOptionPane.showMessageDialog(null, message);
				break;
			case "8":
				student = new StudentBean();
				studentService.deleteInfo(JOptionPane.showInputDialog("아이디 입력"));
				JOptionPane.showMessageDialog(null, message);
				break;
			case "9":
				MainPage mp = new MainPage();
				JOptionPane.showMessageDialog(null, message);
				break;

			}
		}
	}
}
