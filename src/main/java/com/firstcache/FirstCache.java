package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class FirstCache {
	public static void main(String[] args) {
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		
		Student student=s.get(Student.class,1177);
		System.out.println(student);
		
		System.out.println("EWorking something....");
		
		Student student1=s.get(Student.class,1177);
		System.out.println(student1);
		
		//Tells Whether object is present in cache
		System.out.println(s.contains(student1));
		
		//After session closes database has to be hit again
		s.close();
		
		
	}

}