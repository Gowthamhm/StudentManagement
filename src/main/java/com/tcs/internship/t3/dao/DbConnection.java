package com.tcs.internship.t3.dao;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import com.tcs.internship.t3.bean.StudentBean;

public interface DbConnection {
	public void DbConnectionImpl() throws UnsupportedEncodingException, ClassNotFoundException, SQLException;
	public List<StudentBean> getStudentDetail() throws SQLException;
	public StudentBean getStudentDetail(String id) throws SQLException ;
	public void addStudent(StudentBean student) throws SQLException;
	public void updateStudent(StudentBean student, String id) throws SQLException;
	public void deleteStudent(String id) throws SQLException;
}
