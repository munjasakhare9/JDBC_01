package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.Student;

public class StudentDao {
	public int insertStudent(Student s) {
		int check = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap90", "root", "root");
			String sql = "insert into Student(name,city,percentage) values(?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, s.getName());
			pst.setString(2, s.getCity());
			pst.setDouble(3, s.getPercentage());

			check = pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return check;

	}

	public int deleteStudentById(int id) {
		int check = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap90", "root", "root");
			String sql = "delete from Student where id=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);

			check = pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}

	public Student displayStudentById(int id) {
		ResultSet rs=null;
		Student s=null;
		Connection con=null;
		PreparedStatement pst=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jap90","root", "root");
			String sql="select id, name, city, percentage from Student where id=?";
			pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setCity(rs.getString("city"));
				s.setPercentage(rs.getDouble("percentage"));
			}
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return s;
	}
	
	public List<Student> displayAllStudent() {
		ResultSet rs=null;
		Student s=null;
		Connection con=null;
		PreparedStatement pst=null;
		List<Student> al = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jap90","root", "root");
			String sql="select id, name, city, percentage from Student";
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			al=new ArrayList<>();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setCity(rs.getString("city"));
				s.setPercentage(rs.getDouble("percentage"));
				al.add(s);
			}
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return al;
	}
}
