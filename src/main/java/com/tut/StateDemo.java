package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {
	public static void main(String[] args) {
		
		//Practical of Hibernate Object state
		//TRANSIENT
		//Persistent
		//Detached
		//Removed
		System.out.println("Example :");
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		
		//Creating Student object
		
		Student student=new Student();
		student.setId(12323);
		student.setName("Akash");
		student.setCity("Delhi");
		student.setCerti(new Certificate("Java Hibernate course","2 Months"));
		//student: Transient
		
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		s.save(student);
		//student: Persistent- session,database
		
		//student.setName("Akash");
		
		tx.commit(); //For data to be reflected in the database
		//we have to commit  the transaction 
		
		//Closing session
		s.close();
		//updating value after closing Session
		//To check whether changes reflect in database
		
		//Detached State after s.close()
		student.setName("Jay"); //Printing will take place but it won't reflect in the database
		//Changes did not reflect
		//Closing Session after commit as well as where update happened
		//s.close(); //No update takes place in database
		sf.close();
		System.out.println(student);
		
		
		
		
		
		
	}
	

}
