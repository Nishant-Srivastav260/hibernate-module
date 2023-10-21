package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;

public class HqlPagination {
	public static void main(String[] args) {
	
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		 
		Query query=s.createQuery("from Student");
		
		//Implementing Pagination using hibernate
		
		query.setFirstResult(1); //Index of Starting
		query.setMaxResults(5);  //Maximum Students to be displayed per page 
		
		List<Student> list=query.list();
		for(Student st:list) {
			System.out.println(st);
		}
		
		
		
	    
	  s.close();
		sf.close();
		
		
	}

}
