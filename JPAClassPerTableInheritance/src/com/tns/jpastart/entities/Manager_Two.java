package com.tns.jpastart.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="manager_two")
public class Manager_Two extends Employee_Two{
	private static final long serialVersionUID = 1L;
	
	private String department_name;

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	
}
