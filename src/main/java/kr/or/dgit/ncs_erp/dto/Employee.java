package kr.or.dgit.ncs_erp.dto;

import java.util.ArrayList;
import java.util.Date;

public class Employee {
	private String no;
	private String name;
	private Title title;
	private int salary;
	private boolean sex;	
	private Department department;
	private Date joinDate;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String no) {
	
		this.no = no;
	}

	public Employee(String no, String name, Title title, int salary, boolean sex,
			Department department, Date joinDate) {
		super();
		this.no = no;
		this.name = name;
		this.title = title;
		this.salary = salary;
		this.sex = sex;		
		this.department = department;
		this.joinDate = joinDate;
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
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
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
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
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
				"Employee [no=%s, name=%s, title=%s, salary=%s, gender=%s, hobbys=%s, department=%s, joinDate=%s]", no,
				name, title, salary, sex, department, joinDate);
	}
	
	public Object[] toArray() {		
		return new Object[]{no,name,title,String.format("%,d",salary),sex?"남":"여",sex,
				department,String.format("%tF",joinDate)};
	}
	
	
}
