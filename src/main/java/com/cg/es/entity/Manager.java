package com.cg.es.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="managers")
public class Manager {

	@Id
	@Column(name="manager_id")
	private Long managerId;

	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy = "manager")
	private List<ElectronicProductEntity> electronicProducts;
	
	@OneToMany(mappedBy = "manager")
	private List<CustomerEntity> customers;
	
	@OneToMany(mappedBy = "manager")
	private List<ElectronicProductOrderEntity> productOrders;
	

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Manager(Long managerId, String password) {
		super();
		this.managerId = managerId;
		this.password = password;
	}


	public Long getManagerId() {
		return managerId;
	}


	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public List<ElectronicProductEntity> getElectronicProducts() {
		return electronicProducts;
	}


	public void setElectronicProducts(List<ElectronicProductEntity> electronicProducts) {
		this.electronicProducts = electronicProducts;
	}


	public List<CustomerEntity> getCustomers() {
		return customers;
	}


	public void setCustomers(List<CustomerEntity> customers) {
		this.customers = customers;
	}


	public List<ElectronicProductOrderEntity> getProductOrders() {
		return productOrders;
	}


	public void setProductOrders(List<ElectronicProductOrderEntity> productOrders) {
		this.productOrders = productOrders;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + ((electronicProducts == null) ? 0 : electronicProducts.hashCode());
		result = prime * result + ((managerId == null) ? 0 : managerId.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Manager other = (Manager) obj;
		if (customers == null) {
			if (other.customers != null)
				return false;
		} else if (!customers.equals(other.customers))
			return false;
		if (electronicProducts == null) {
			if (other.electronicProducts != null)
				return false;
		} else if (!electronicProducts.equals(other.electronicProducts))
			return false;
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
				"Manager [managerId=%s, password=%s, electronicProducts=%s, customers=%s, productOrders=%s]", managerId,
				password, electronicProducts, customers, productOrders);
	}
	
	
		
	
}
