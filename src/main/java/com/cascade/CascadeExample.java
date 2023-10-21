package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadeExample {
	public static void main(String[] args) {
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		
		//Using com.map package for one to many 
		
		Question q1=new Question();
		
		q1.setQuestionId(565);
		q1.setQuestion("What is Spring?");
		
		Answer a1=new Answer(445,"It is a framework for creating web Apps",q1); 
		Answer a2=new Answer(222,"Easy to use ",q1);
		Answer a3=new Answer(363,"Structured",q1);
		List<Answer> list=new ArrayList<Answer>();
		list.add(a1); 
		list.add(a2);
		list.add(a3);
		
		q1.setAnswer(list);
		
		Transaction tx=s.beginTransaction();
		
		s.save(q1);
		//If we Don't use cascade then we have to save every answe separately for 
		//it to reflect in the datebase
//		s.save(a1);
//		s.save(a2);
//		s.save(a3);
//		
		
		
		
		
		
		
		tx.commit();
		s.close();
		sf.close();
		
		
		
	}

}
