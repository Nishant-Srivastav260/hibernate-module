package com.hql;


import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class HQLExample {
	
	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session s=sf.openSession();
		//HQL
		//Syntax
		
		//First method to fire query i.e directly write it 
		//String query="from Student where city='Gkp' ";
		
		
		//Second Method to fire query using Alias 
		String query="from Student s where s.city= :x and s.certi.duration=: y";
		
		//Session has a method to fire the query, for that we have to
		//get the object of the session
		 Query q=s.createQuery(query);
		 
		 q.setParameter("x","Gkp");
		 q.setParameter("y","2 Months");
		 
		 
		 
		 
		 //query can bring single result or multiple result
		 //Single - Unique result 
		 //Multiple- list
		 List<Student> list=q.list(); //If we want single result then we would write q.uniqueResult()
		 
		 for(Student student:list) {
			 System.out.println(student.getName()+" : "+student.getCerti());
		 }
		 
		 System.out.println("Deleting data whose city is Abc");
		 //Since we have to update the Database so we have to begin transaction
		 
		 Transaction tx=s.beginTransaction();
		 
		 //HQL query for DELETE
//		 Query q2=s.createQuery("delete from Student s where s.city=:a");
//		 q2.setParameter("a", "Abc");
//       int r=q2.executeUpdate();
//		 System.out.println("Deleted: ");
//		 System.out.println(r);
		 
		 //Hql query for UPDATE
//		 Query q3=s.createQuery("update Student s set s.city=: c where s.name=:n ");
//		 q3.setParameter("c", "Lko");
//		 q3.setParameter("n","Harsh");
//		 int r1=q3.executeUpdate();
//		 System.out.println(r1+" objects updated");
		 
		 
		 //HQl query for INNER JOIN
		 //Using Question and Answers example 
		 Query q4=s.createQuery("select q.question, q.questionId,a.answer from Question q INNER JOIN q.answer as a ");
		 
		 List<Object[]> list3=q4.getResultList();
		 
		 for(Object[] arr :list3) {
			 System.out.println(Arrays.toString(arr));
		 }
		
		 tx.commit();
		s.close();
		sf.close();
		
		
	}

}
