package kr.or.dgit.ncs_erp.dto;

public class Department {
	private String no;
	private String name;
	private int floor;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(String no) {
		super();
		this.no = no;
	}
	public Department(String no, String name, int floor) {
		super();
		this.no = no;
		this.name = name;
		this.floor = floor;
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
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
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
		if (!(obj instanceof Department)) {
			return false;
		}
		Department other = (Department) obj;
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
		return String.format("[%s, %s, %s]", no, name, floor);
	}
	
	public Object[] toArray() {		
		return new Object[]{no, name, floor};
	}
	
	
}
