package com.tut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
       // System.out.println(factory);
        //System.out.println(factory.isClosed());
        
        //Creating Student Object
        Student st=new Student();
        st.setId(106);
        st.setName("Nishant");
        st.setCity("Gorakhpur");
        System.out.println(st);
        
        //Creating Address object
        Address ad=new Address();
        ad.setStreet("street3");
        ad.setCity("Hyder");
        ad.setIsOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.264);
        
        //reading image
        FileInputStream fis=new FileInputStream("src/main/java/Screenshot (357).png");
        byte[] data=new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
       
        Session session=factory.openSession();
        
        Transaction tx=session.beginTransaction()  ;
        session.save(st);
        session.save(ad);
        tx.commit();
        session.close();
        System.out.println("Done..");
        
        
        
        
        
        }
}
