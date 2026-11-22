package com.demo;

import java.util.Iterator;
import java.util.List;

import com.demo.dao.StudentDao;
import com.demo.model.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		StudentDao sd = new StudentDao();

		// insert student data

		/*
		 * Student s = new Student(); s.setName("bhanuprasad"); s.setCity("nandedd");
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * s.setPercentage(85.70); System.out.println(sd.insertStudent(s));
		 */

		/*
		 * // delete student data System.out.println(sd.deleteStudentById(9));
		 */

		/*
		 * // display student by id
		 * 
		 * System.out.println(sd.displayStudentById(9));
		 */

		// display all student

		List<Student> al = sd.displayAllStudent();

		Iterator<Student> itr = al.iterator();
		while (itr.hasNext()) {
			Student s = itr.next();
			System.out.println(s.getId() + " -- " + s.getName() + " -- " + s.getCity() + " -- " + s.getPercentage());
		}

	}
}
