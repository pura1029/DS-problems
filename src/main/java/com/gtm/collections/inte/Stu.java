package com.gtm.collections.inte;

public class Stu implements Comparable<Stu>{

	private int id;
	private String name;


	public int getId() {
		return id;
	}
	public void setId(int empId) {
		this.id = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stu other = (Stu) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public int compareTo(Stu s2) {
		if (this.getId() > s2.getId()) {
			return 1;
		}else if(this.getId() < s2.getId()) {
			return -1;
		}else{
			return 0;
		}
	}
}
