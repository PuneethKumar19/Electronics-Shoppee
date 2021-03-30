package com.cg.es.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;




public class CustomerModel {

	@NotEmpty(message="customerId  cannot be empty")
	@NotNull(message = "customerId cannot be omitted")
	private Long customerId;
	
	@NotEmpty(message="customerName  cannot be empty")
	@NotNull(message = "customerName cannot be omitted")
	private String customerName;
	
	@NotEmpty(message="customerPassword  cannot be empty")
	@NotNull(message = "customerpassword cannot be omitted")
	private String customerPassword;

	@NotEmpty(message="customerEmail  cannot be empty")
	@NotNull(message = "customerEmail cannot be omitted")
	@Pattern(regexp="^[A-Za-z0-9]{3,}[@][a-z]{2,}[a-z.]{2,}[a-z]$")
	private String customerEmail;

	@NotEmpty(message="customerPhone  cannot be empty")
	@NotNull(message = "customerPhone cannot be omitted")
	@Pattern(regexp = "[6-9][0-9]{9}")
	private String customerPhone;

	private AddressModel address;
    
	private Long managerId;
	
	
	public CustomerModel() {
		super();
	}

	public CustomerModel(Long customerId,
			@NotEmpty(message = "customerName  cannot be empty") @NotNull(message = "customerName cannot be omitted") String customerName,
			@NotEmpty(message = "customerPassword  cannot be empty") @NotNull(message = "customerpassword cannot be omitted") String customerPassword,
			@NotEmpty(message = "customerEmail  cannot be empty") @NotNull(message = "customerEmail cannot be omitted") @Pattern(regexp = "^[A-Za-z0-9]{3,}[@][a-z]{2,}[a-z.]{2,}[a-z]$") String customerEmail,
			@NotEmpty(message = "customerPhone  cannot be empty") @NotNull(message = "customerPhone cannot be omitted") @Pattern(regexp = "[6-9][0-9]{9}") String customerPhone,
			AddressModel address,
			@NotEmpty(message = "managerId  cannot be empty") @NotNull(message = "managerId cannot be omitted") Long managerId) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.address = address;
		this.managerId = managerId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


	

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public AddressModel getAddress() {
		return address;
	}

	public void setAddress(AddressModel address) {
		this.address = address;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((customerEmail == null) ? 0 : customerEmail.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((customerPassword == null) ? 0 : customerPassword.hashCode());
		result = prime * result + ((customerPhone == null) ? 0 : customerPhone.hashCode());
		result = prime * result + ((managerId == null) ? 0 : managerId.hashCode());
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
		CustomerModel other = (CustomerModel) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (customerEmail == null) {
			if (other.customerEmail != null)
				return false;
		} else if (!customerEmail.equals(other.customerEmail))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerPassword == null) {
			if (other.customerPassword != null)
				return false;
		} else if (!customerPassword.equals(other.customerPassword))
			return false;
		if (customerPhone == null) {
			if (other.customerPhone != null)
				return false;
		} else if (!customerPhone.equals(other.customerPhone))
			return false;
		if (managerId == null) {
			if (other.managerId != null)
				return false;
		} else if (!managerId.equals(other.managerId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"CustomerModel [customerId=%s, customerName=%s, customerPassword=%s, customerEmail=%s, customerPhone=%s, address=%s, managerId=%s]",
				customerId, customerName, customerPassword, customerEmail, customerPhone, address, managerId);
	}


	
	

	

	
	
}
