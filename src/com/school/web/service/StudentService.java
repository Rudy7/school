package com.school.web.service;

import com.school.web.bean.StudentBean;

public interface StudentService {
	public void addStudent(StudentBean studentBean); 
	public void addScore(StudentBean score);
	public StudentBean login(StudentBean studentBean);
	public StudentBean find(String id);
	
	
}
