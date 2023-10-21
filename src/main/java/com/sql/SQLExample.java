package com.sql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.tut.Student;

public class SQLExample {
	public static void main(String[] args) {
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s= sf.openSession();
		
		//SQL Query
		String q="Select * from student";
		
		//Query query=s.createQuery(q); //createquery expects HQL 
		//But if we want to write SQL query the use following
		//We can use Query as well here but Since Sql is a native query we will use NativeQuery instead of Query
		NativeQuery nq=s.createSQLQuery(q);
		//List<Student> list=nq.list(); //Since we are using native query so sql would not know that whether Student is a class
		//beacuse it treats it as table. So it return in form of Object rather than Student class.So we use following
		
		List<Object[]> list=nq.list();
		
		
		
		for(Object[] st:list) {
			System.out.println(Arrays.toString(st));
		}
		
		
		
		
		
		
		s.close();
		sf.close();
		
		
		
		
	}

}
