package com.jpa.start.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_two")
public class Student implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int student_uid;
	
	private String student_name;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_uid")
	private Address address;
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public int getStudent_uid() {
		return student_uid;
	}
	@Override
	public String toString() {
		return "Student [student_uid=" + student_uid + ", student_name=" + student_name + ", address=" + address
				+ ", getAddress()=" + getAddress() + ", getStudent_uid()=" + getStudent_uid() + ", getStudent_name()="
				+ getStudent_name() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public void setStudent_uid(int student_uid) {
		this.student_uid = student_uid;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	
}
