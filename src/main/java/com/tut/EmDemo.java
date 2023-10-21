package com.tut;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	
	public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
	
        Student student1=new Student();
        student1.setId(14134);
        student1.setName("Ankit tiwari");
        student1.setCity("LKO");
        
        Certificate certificate=new Certificate();
        certificate.setCourse("Android");
        certificate.setDuration("2 months");
        student1.setCerti(certificate);
        
        Student student2=new Student();
        student2.setId(1211);
        student2.setName("ravi tiwari");
        student2.setCity("Delhi");
        
        Certificate certificate1=new Certificate();
        certificate1.setCourse("Hibernate");
        certificate1.setDuration("3 months");
        student2.setCerti(certificate1);
        
        Session s=factory.openSession();
        Transaction tx=s.beginTransaction();
        
        s.save(student1);
        s.save(student2);
        
        tx.commit();
        s.close();
        factory.close();

}}
