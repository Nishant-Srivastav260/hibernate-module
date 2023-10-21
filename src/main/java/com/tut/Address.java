package com.tut;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="student_address")
public class Address {

	@Id //Specifying Primary key
	@GeneratedValue(strategy= GenerationType.IDENTITY)//Updating it on basis of Identity rather than Sequence
	@Column(name="address_id")
private int addressId;
	
@Column(length=50,name="STREET") //Specifying max length of each street and Column name =Street
private String street;
@Column(length=50,name="CITY")
private String city;
@Column(name="is_open")
private boolean isOpen;

@Transient   //We don't want to include the column x
private double x;
@Column(name="added_date")
@Temporal(TemporalType.DATE)  //Only date will be added time stamp will Not be there
private Date addedDate;

@Lob  //LOB means large object and we want the image to be large
private byte[] image;

public Address() {
	super();
	// TODO Auto-generated constructor stub
}
public Address(int addressId, String street, String city, boolean isOpen, double x, Date addedDate, byte[] image) {
	super();
	this.addressId = addressId;
	this.street = street;
	this.city = city;
	this.isOpen = isOpen;
	this.x = x;
	this.addedDate = addedDate;
	this.image = image;
}
public int getAddressId() {
	return addressId;
}
public void setAddressId(int addressId) {
	this.addressId = addressId;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public boolean getIsOpen() {
	return isOpen;
}
public void setIsOpen(boolean isOpen) {
	this.isOpen = isOpen;
}
public double getX() {
	return x;
}
public void setX(double x) {
	this.x = x;
}
public Date getAddedDate() {
	return addedDate;
}
public void setAddedDate(Date addedDate) {
	this.addedDate = addedDate;
}
public byte[] getImage() {
	return image;
}
public void setImage(byte[] image) {
	this.image = image;
}
@Override
public String toString() {
	return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", isOpen=" + isOpen + ", x="
			+ x + ", addedDate=" + addedDate + ", image=" + Arrays.toString(image) + "]";
}


	
	
	
}
