package com.cognizant.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.model.Student;


public class StudentDaoTest {

	private StudentDao studentDao;
	private Student student;
	@Before
	public void setup() {
    	@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(resources.ApplicationConfig.class);
    	this.studentDao = (StudentDao)context.getBean("studentDao");
		this.student = new Student(1, "X", 100.0f);
	}
	
	
	@Test
	public void testInsert() {
		boolean actual = studentDao.insert(student);
		boolean expected = true;
	    assertEquals(expected, actual);
	}

	@Test
	public void testGetAll() {
		List<com.cognizant.model.Student> students = studentDao.getAll();
		assertEquals(8, students.size());
		assertEquals(student, students.get(0));
	}

}