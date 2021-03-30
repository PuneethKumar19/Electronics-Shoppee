package com.cg.es.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class ManagerModel {

	@NotEmpty(message="managerId  cannot be empty")
	@NotNull(message = "managerId cannot be omitted")
	private Long managerId;


	@NotEmpty(message="password cannot be empty")
	@NotNull(message="password cannot be omitted")
	private String password;


	public ManagerModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ManagerModel(Long managerId, String password) {
		super();
		this.managerId = managerId;
		this.password = password;
	}


	public Long getManagerId() {
		return managerId;
	}


	public void setId(Long managerId) {
		this.managerId = managerId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((managerId == null) ? 0 : managerId.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		ManagerModel other = (ManagerModel) obj;
		if (managerId == null) {
			if (other.managerId != null)
				return false;
		} else if (!managerId.equals(other.managerId))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return String.format("ManagerModel [id=%s, password=%s]", managerId, password);
	}
	
		
}
