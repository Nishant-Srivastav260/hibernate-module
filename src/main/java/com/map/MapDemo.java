package com.map;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        
      //Creating question
//        Question q1=new Question();
//        q1.setQuestionId(123);
//        q1.setQuestion("What is java");
//        
//        
//        //Creating answer
//        Answer a1=new Answer();
//       a1.setAnswerId(343);
//       a1.setAnswer("Java is a programming language");
//       a1.setQuestion(q1);
//       
//       Answer a2=new Answer();
//       a2.setAnswerId(33);
//       a2.setAnswer("With the help of java we can create softwares");
//       a2.setQuestion(q1);
//       
//       Answer a3=new Answer();
//       a3.setAnswerId(363);
//       a3.setAnswer("Java has different type of frameworks");
//       a3.setQuestion(q1);
//       
//       //Adding these questions in a list
//        List<Answer> list=new ArrayList<Answer>();
//        list.add(a1);
//        list.add(a2);
//        list.add(a3);
//       
//       q1.setAnswer(list);   
//      
       
       //Session
       
       Session s=factory.openSession();
       Transaction tx=s.beginTransaction();
       
       //Save
       
//      s.save(q1);
//       s.save(a1);
//       s.save(a2);
//       s.save(a3);
       
       //Lazy and Eager loading Examples
       Question q=s.get(Question.class,123);
       
       //If we Don't specify anything in mapped by then default Lazy Loading is considered
      //This is an Example of Eager loading
       System.out.println(q.getQuestionId());
       System.out.println(q.getQuestion());
       
       //In Lazy loading as soon as we access the Answers the answers get loaded whereas in Eager loading it will
       //be accessed even if we don't call the answers.
      
       System.out.println(q.getAnswer().size());
       
       
//       
       // Fetching the data
//      Question q=(Question)s.get(Question.class,123 );
//       System.out.println(q.getQuestion());
//       
//       for(Answer ans: q.getAnswer()) {
//    	   System.out.println(ans.getAnswer()); 
//       }  
	
	
      tx.commit();
      
//     Question newQ=s.get(Question.class, 123);
//      System.out.println(newQ.getQuestion());
//      System.out.println(newQ.getAnswer().getAnswer());
//        
        s.close() ;       
        factory.close();

}}
