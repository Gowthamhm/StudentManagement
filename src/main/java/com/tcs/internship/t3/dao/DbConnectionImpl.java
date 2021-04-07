package com.tcs.internship.t3.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tcs.internship.t3.bean.StudentBean;

@Repository
public abstract class DbConnectionImpl implements DbConnection{

	Connection conn;

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public DbConnectionImpl() throws UnsupportedEncodingException, ClassNotFoundException, SQLException {
		String rootPath = null;
		rootPath = getPath();
//		System.out.println("root path :"+ rootPath );
		rootPath = rootPath + "src/main/webapp/WEB-INF/";
//		System.out.println("root path :"+ rootPath );
		rootPath = rootPath + "MyDB";
		System.out.println("Root Path" + rootPath);
		Class.forName("org.h2.Driver");
		this.conn = DriverManager.getConnection("jdbc:h2:" + rootPath + ";create=true", "", "");
		System.out.println(conn);
		return;
	}

	private String getPath() throws UnsupportedEncodingException {
		String path = this.getClass().getClassLoader().getResource("").getPath();
		String fullPath = URLDecoder.decode(path, "UTF-8");
//        System.out.println("Full Path : " + fullPath);
		fullPath = fullPath.replace("target/classes/", "");
		System.out.println("Full Path : " + fullPath);
		return fullPath;
	}

	public List<StudentBean> getStudentDetail() throws SQLException {
		List<StudentBean> StudentDetail = new ArrayList<>();
		String getall ="select * from student";
		PreparedStatement ps = conn.prepareStatement(getall);
		System.out.println(getall);
		  ResultSet rs = ps.executeQuery();
		while (rs.next()) {
//			System.out.println(rs.getString("STUDENTID"));
//			System.out.println(rs.getString("STUDENTNAME"));
//			System.out.println(rs.getInt("MARKS"));
			StudentBean s = new StudentBean(rs.getString("STUDENTID"),rs.getString("STUDENTNAME"),rs.getInt("MARKS"));
			StudentDetail.add(s);
		}
		return StudentDetail;
	}

	public StudentBean getStudentDetail(String id) throws SQLException {
		String getall ="select * from student where STUDENTID='"+id+"'";
		PreparedStatement ps = conn.prepareStatement(getall);
		StudentBean s = null;
		System.out.println(getall);
		  ResultSet rs = ps.executeQuery();
		while (rs.next()) {
//			System.out.println(rs.getString("STUDENTID"));
//			System.out.println(rs.getString("STUDENTNAME"));
//			System.out.println(rs.getInt("MARKS"));
			s = new StudentBean(rs.getString("STUDENTID"),rs.getString("STUDENTNAME"),rs.getInt("MARKS"));
		}
		return s;
	}

	public void addStudent(StudentBean student) throws SQLException {
		String query = " insert into student (STUDENTID, STUDENTNAME, MARKS)"
		        + " values (?, ?, ?)";
		 PreparedStatement preparedStmt = conn.prepareStatement(query);
		 preparedStmt.setString(1,student.getStudentId());
		 preparedStmt.setString(2, student.getStudentName());
		 preparedStmt.setDouble(3, student.getMarks());
		 preparedStmt.execute();
		 preparedStmt.closeOnCompletion();
	}

	public void updateStudent(StudentBean student, String id) throws SQLException {
		String update = " update student set studentid ='"+student.getStudentId()+"',STUDENTNAME ='"+student.getStudentName()+"',MARKS="+student.getMarks()+" where STUDENTID='"+id+"'";
		Statement stmt=conn.createStatement();
		stmt.executeUpdate(update);
		stmt.closeOnCompletion();
	}

	public void deleteStudent(String id) throws SQLException {
		 Statement stmt = conn.createStatement();
		String delete = "delete from student where studentid ='"+id+"'";
		stmt.executeUpdate(delete);
		stmt.closeOnCompletion();
	}
}
