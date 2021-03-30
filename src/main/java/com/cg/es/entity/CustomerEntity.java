package com.cg.es.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cg.es.model.AddressModel;



@Entity
@Table(name="customers")
public class CustomerEntity {

	@Id
	@Column(name="customer_id")
	private Long customerId;

	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="customer_password")
	private String customerPassword;

	@Column(name="customer_email")
	private String customerEmail;

	@Column(name="customer_phone")
	private String customerPhone;

	@Column(name="adress")
	@Embedded
	private AddressModel address;
     
	@OneToMany(mappedBy="customer")
	private List<BasketEntity> basket;
	
	@OneToMany(mappedBy="customer")
	private List<ElectronicProductEntity> elecproduct;
	
	@OneToMany(mappedBy = "customer")
	private List<ElectronicProductOrderEntity> productOrders;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="manager_id")
	private Manager manager;


	public CustomerEntity() {
		super();
	}

	public CustomerEntity(Long customerId, String customerName, String customerPassword, String customerEmail,
			String customerPhone, AddressModel address, Manager manager) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.address = address;
		this.manager = manager;
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

	public List<BasketEntity> getBasket() {
		return basket;
	}

	public void setBasket(List<BasketEntity> basket) {
		this.basket = basket;
	}

	public List<ElectronicProductOrderEntity> getProductOrders() {
		return productOrders;
	}

	public void setProductOrders(List<ElectronicProductOrderEntity> productOrders) {
		this.productOrders = productOrders;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	public List<ElectronicProductEntity> getElecproduct() {
		return elecproduct;
	}

	public void setElecproduct(List<ElectronicProductEntity> elecproduct) {
		this.elecproduct = elecproduct;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((basket == null) ? 0 : basket.hashCode());
		result = prime * result + ((customerEmail == null) ? 0 : customerEmail.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((customerPassword == null) ? 0 : customerPassword.hashCode());
		result = prime * result + ((customerPhone == null) ? 0 : customerPhone.hashCode());
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		result = prime * result + ((productOrders == null) ? 0 : productOrders.hashCode());
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
		CustomerEntity other = (CustomerEntity) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (basket == null) {
			if (other.basket != null)
				return false;
		} else if (!basket.equals(other.basket))
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
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		if (productOrders == null) {
			if (other.productOrders != null)
				return false;
		} else if (!productOrders.equals(other.productOrders))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"CustomerEntity [customerId=%s, customerName=%s, customerPassword=%s, customerEmail=%s, customerPhone=%s, address=%s, basket=%s, productOrders=%s, manager=%s]",
				customerId, customerName, customerPassword, customerEmail, customerPhone, address, basket,
				productOrders, manager);
	}

		
	

	
	
	
}
