package com.cg.es.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.cg.es.entity.CustomerEntity;

@Embeddable
public class AddressModel implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotNull
	private String doorNo;
	
	@NotNull(message="street name cannot be null")	
	@NotBlank(message="street name cannot be blank")
	private String street;
	
	@NotNull(message="area name cannot be null")	
	@NotBlank(message="area name cannot be blank")
	private String area;
	
	@NotNull(message="city name cannot be null")	
	@NotBlank(message="city name cannot be blank")
	private String city;
	
	@NotNull(message="state name cannot be null")	
	@NotBlank(message="state cannot be blank")
	private String state;
	
	@NotNull(message="pincode cannot be null")	
	@NotBlank(message="full name cannot be blank")
	@Pattern(regexp = "[0-9]{6}")
	private Integer pincode;
	
	@OneToMany
	private Set<CustomerEntity> customers;
	
	public AddressModel() {
		/* Default Constructor */
	}

	public AddressModel(String doorNo, String street, String area, String city, String state, Integer pincode) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
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

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((doorNo == null) ? 0 : doorNo.hashCode());
		result = prime * result + ((pincode == null) ? 0 : pincode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
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
		AddressModel other = (AddressModel) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (doorNo == null) {
			if (other.doorNo != null)
				return false;
		} else if (!doorNo.equals(other.doorNo))
			return false;
		if (pincode == null) {
			if (other.pincode != null)
				return false;
		} else if (!pincode.equals(other.pincode))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("doorNo=%s, street=%s, area=%s, city=%s, state=%s, pincode=%s", doorNo, street,
				area, city, state, pincode);
	}
}
