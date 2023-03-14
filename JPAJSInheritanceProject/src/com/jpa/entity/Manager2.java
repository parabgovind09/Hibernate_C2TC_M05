package com.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="manager_three")
public class Manager2 extends Employee2 {

	private static final long serialVersionUID = 1L;
	
	private String department_name;

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	
}
