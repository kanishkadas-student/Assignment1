package com.cognizant.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.dao.StudentDao;
import com.cognizant.model.Student;

/**
 * Hello world!
 *
 */
public class MainApp 
{
	
	
    public static void main( String[] args )
    {
    	@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(resources.ApplicationConfig.class);
    	StudentDao studentDao = (StudentDao)context.getBean("studentDao");
    	Student s1 = new Student(1, "X", 100);
    	Student s2 = new Student(2, "Y", 90);
    	Student s3 = new Student(3, "Z", 80);
    	studentDao.insert(s1);
    	studentDao.insert(s2);
    	studentDao.insert(s3);
        List<Student> students = studentDao.getAll();
        students.forEach(student->System.out.println(student));
    }
}