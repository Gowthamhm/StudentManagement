package com.tcs.internship.t3.bean;

public class StudentBean {
	private String StudentId;
	private String StudentName;
	private double marks;

	public StudentBean() {
		super();
	}

	public StudentBean(String studentId, String studentName, double marks) {
		super();
		StudentId = studentId;
		StudentName = studentName;
		this.marks = marks;
	}

	public String getStudentId() {
		return StudentId;
	}

	public void setStudentId(String studentId) {
		StudentId = studentId;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

}
