package com.jpa.start.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address_two")
public class Address implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="address_uid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int address_uid;
	
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Address [address_uid=" + address_uid + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", zipcode=" + zipcode + ", student=" + student + ", getStudent()=" + getStudent()
				+ ", getAddress_uid()=" + getAddress_uid() + ", getStreet()=" + getStreet() + ", getCity()=" + getCity()
				+ ", getState()=" + getState() + ", getZipcode()=" + getZipcode() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Column(name="state")
	private String state;
	
	@Column(name="zipcode")
	private String zipcode;

	@OneToOne(mappedBy="address")
	private Student student;

	public int getAddress_uid() {
		return address_uid;
	}

	public void setAddress_uid(int address_uid) {
		this.address_uid = address_uid;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
}
