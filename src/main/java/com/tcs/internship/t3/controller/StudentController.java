package com.tcs.internship.t3.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.internship.t3.bean.StudentBean;
import com.tcs.internship.t3.service.StudentServiceImpl;

@RestController
public class StudentController {

	@Autowired
	private StudentServiceImpl ss;
	
	@RequestMapping("/getStudent")
	public List<StudentBean> getAllStudent() throws SQLException{
		return ss.getAllStudents();
	}
	@RequestMapping("/getStudent/{id}")
	public StudentBean getStudent(@PathVariable String id) throws SQLException{
		return ss.getStudent(id);
	}
	@RequestMapping(method=RequestMethod.POST,value="/addStudent")
	public List<StudentBean> addStudent(@RequestBody StudentBean student) throws SQLException {
		ss.addStudent(student);
		return ss.getAllStudents();
	}
	@RequestMapping(method=RequestMethod.PUT,value="/updateStudent/{id}")
	public List<StudentBean> updateStudent(@RequestBody StudentBean student,@PathVariable String id) throws SQLException {
		ss.updateStudent(student,id);
		return ss.getAllStudents();
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/deleteStudent/{id}")
	public List<StudentBean> deleteStudent(@PathVariable String id) throws SQLException {
		ss.deleteStudent(id);
		return ss.getAllStudents();
	}
	
	@RequestMapping("/Student")
	public List<StudentBean> getAllStudents() throws SQLException{
		return ss.getAllStudents();
	}
	@RequestMapping("/Student/{id}")
	public StudentBean getStudents(@PathVariable String id) throws SQLException{
		return ss.getStudent(id);
	}
	@RequestMapping(method=RequestMethod.POST,value="/Student")
	public List<StudentBean> addStudents(@RequestBody StudentBean student) throws SQLException {
		ss.addStudent(student);
		return ss.getAllStudents();
	}
	@RequestMapping(method=RequestMethod.PUT,value="/Student/{id}")
	public List<StudentBean> updateStudents(@RequestBody StudentBean student,@PathVariable String id) throws SQLException {
		ss.updateStudent(student,id);
		return ss.getAllStudents();
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/Student/{id}")
	public List<StudentBean> deleteStudents(@PathVariable String id) throws SQLException {
		ss.deleteStudent(id);
		return ss.getAllStudents();
	}
}
