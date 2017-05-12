package kr.or.dgit.ncs_erp.dto;

import java.util.ArrayList;
import java.util.Date;

public class Employee {
	private String no;
	private String name;
	private Title eTitle;
	private int salary;
	private boolean sex;	
	private Department eDepartment;
	private String eJoinDate;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String no) {
	
		this.no = no;
	}

	public Employee(String no, String name, Title title, int salary, boolean sex,
			Department department, String joinDate) {
		super();
		this.no = no;
		this.name = name;
		this.eTitle = title;
		this.salary = salary;
		this.sex = sex;		
		this.eDepartment = department;
		this.eJoinDate = joinDate;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Title getTitle() {
		return eTitle;
	}

	public void setTitle(Title title) {
		this.eTitle = title;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}


	public Department getDepartment() {
		return eDepartment;
	}

	public void setDepartment(Department department) {
		this.eDepartment = department;
	}

	public String getJoinDate() {
		return eJoinDate;
	}

	public void setJoinDate(String joinDate) {
		this.eJoinDate = joinDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		if (no == null) {
			if (other.no != null) {
				return false;
			}
		} else if (!no.equals(other.no)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"%s, %s, %s, %s, %s, %s, %s, %s", 
				no,	name, eTitle, salary, sex, eDepartment, eJoinDate);
	}
	
	public Object[] toArray() {		
		return new Object[]{no,name,eTitle.getName() ,salary , sex?"남":"여",
				eDepartment.getName() ,eJoinDate};
	}
	
	
}
