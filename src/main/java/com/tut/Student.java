package com.tut;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

//Now we have to map this class to database tables 
//For that we have to make this class as @Entity
//Also changing the name of entity
@Entity
@Cacheable //For Implementing Second Level cache
@Cache(usage =CacheConcurrencyStrategy.READ_ONLY)
public class Student {
	
	//Making Id Primary key 
	@Id
	private int id;
	private String name;
	private String city;
	private Certificate certi;
	
	public Student() {
		super();
		
	}
	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	} 
	public Certificate getCerti() {
		return certi;
	}
	public void setCerti(Certificate certi) {
		this.certi = certi;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + "Certi="+certi.getCourse() + "]";
	}
	
	
	

}
