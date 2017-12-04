package com.school.web.serviceImpl;

import com.school.web.bean.StudentBean;
import com.school.web.service.StudentService;

public class StudentServiceImpl implements StudentService {
	
	private StudentBean[] students;
	private int count;
	
	public StudentServiceImpl(int count) {
		students = new StudentBean[count];
		this.count = 0;
	}
	@Override
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public int getCount() {
		return count;
	}
	@Override
	public void addStudent(StudentBean student) {   // 보이드는 답이 없다.  디스를 내 안에서  리턴 없이 
		this.students [count] = student;
		count++;
	}
	@Override
	public void addScore(StudentBean score) {
		
	}
	@Override
	public StudentBean login(StudentBean student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentBean find(String id) {
		// TODO Auto-generated method stub
		return null;
		}
	@Override
	public StudentBean[] list() {
		
		return students;
	}														//  검색엔지이다.  기초이다. 
	@Override										//진실은 클래스다  StudentBean 이다.  find 이건 덜 중요. 
	public StudentBean findStudentById(String id) {   // 아이디는 빈에 담지 않는다.  오픈된 정보니까. 
		// TODO Auto-generated method stub
		StudentBean student = new StudentBean();
		//월드컵 우승국은 32개중 하나인 것처럼 아이디로 개인정보 찾는건 스튜던츠빈이다. 
		for(int i = 0; i < count; i++) {
			if(id.equals(students[i].getId())) {     // 대박이다.  잘 만들었다.   굿굿 (equals대신에 ==을 쓰지 않는 이유 ==는 숫자연산할때 쓰는거라서. 에러는 안난다 이유--두 아이디의 주소값을 비교하기 때문이다.) 
//			if(students[i].getId().equals(id)) {}	 이줄과 윗줄 중 어느 게 더 좋을까?  왼쪽은정해진값. 오른쪽은 많은데이터가 있다. 왼쪽엔 상수값을 주고, 오른쪽에 변수를 준다.  퍼포먼스 차이 확실히 난다. 
				student = students[i];
				break;
			}                                  // 아래줄을 쓰면 퍼포먼스가 떨어진다. 상관없지 않다. 검색엔진의 기본이다. 조심해야겠다.
		
		}
//		String userid = students[6].getId();
		return student;										//foo는 껍데기일 뿐이에요.  담기위한 변수이름일 뿐. 버려진다. CG 가비지콜렉터
	}
//	StudentBean foo = new StudentBean();
//	return foo;					
	@Override
	public StudentBean[] findStudentByName(String name) {
		StudentBean[] studentc = null;
		int res = 0, j = 0;
		for(int i=0; i<count; i++) {
			if(name.equals(students[i].getName())) {
				res++;		
			}
	    }
		if(res != 0) {
			studentc = new StudentBean[res];
			for(int i=0; i<count; i++) {
				if(name.equals(students[i].getName())) {
			studentc[j] = students[i];
			j++;
			if(j == res) 
			break;
			}
		}		
	}		
		return studentc;
	}
	
	}
	








