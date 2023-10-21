package com.map1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {
	public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        
        Emp e1=new Emp(34,"Ram");
        Emp e2=new Emp(35, "Shyam");
        
 
        Project p1=new Project(12121, "Library management System");
        Project p2=new Project(14214, "Chatbot");
        
        List<Emp> list1=new ArrayList<Emp>();
        List<Project> list2=new ArrayList<Project>();
        
        list1.add(e1);
        list1.add(e2);
        
        list2.add(p1);
        list2.add(p2);
        
        //Employee 1 is assigned with 2 projects
        e1.setProjects(list2);
        
        //Project 1 is assigned to 2 employee
        p2.setEmps(list1);
        
        
        
        Session s=factory.openSession();
        Transaction tx=s.beginTransaction();
        
        s.save(e1);
        s.save(e2);
        s.save(p1);
        s.save(p2);
        		
        		
       tx.commit();
        
        factory.close();
        
}}
