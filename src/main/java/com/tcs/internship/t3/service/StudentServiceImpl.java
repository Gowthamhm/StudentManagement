package com.tcs.internship.t3.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.internship.t3.bean.StudentBean;
import com.tcs.internship.t3.dao.DbConnectionImpl;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private DbConnectionImpl db;

	public List<StudentBean> getAllStudents() throws SQLException{
		List<StudentBean> allStudentDetails = db.getStudentDetail();
		return allStudentDetails;
	}
	public StudentBean getStudent(String id) throws SQLException {
		StudentBean student = db.getStudentDetail(id);
		return student;
	}
	public void addStudent(StudentBean student) throws SQLException {
		db.addStudent(student);
	}
	public void updateStudent(StudentBean student, String id) throws SQLException {
		db.updateStudent(student,id);
	}
	public void deleteStudent(String id) throws SQLException {
		db.deleteStudent(id);
	}

}
