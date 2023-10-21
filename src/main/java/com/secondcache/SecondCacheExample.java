package com.secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.cache.ehcache.internal.EhcacheRegionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

//import net.sf.ehcache.hibernate.EhCacheRegionFactory;

public class SecondCacheExample {
	public static void main(String[] args) {
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		//First Session
		Session session1=sf.openSession();
		Student student1=session1.get(Student.class, 1211);
		System.out.println(student1);
		
		session1.close();
		
		//Second session
		Session session2=sf.openSession();
		Student student2=session2.get(Student.class, 1211);
		System.out.println(student2);
		
		session2.close();
	
	}

}
