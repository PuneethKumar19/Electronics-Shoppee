package com.cg.es.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="electronic_product_orders")
public class ElectronicProductOrderEntity {

	@Id
	@Column(name="order_id")
	private Long orderId;
	
	@Column(name="product_qty")
	private Integer productQty;
	
	@Column(name="order_date")
	private LocalDate orderDate;
	
	
	@Column(name="amount")	
	private double amount;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private CustomerEntity customer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="basket_id")
	private BasketEntity basket;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="manager_id")
	private Manager manager;
	

	public ElectronicProductOrderEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public ElectronicProductOrderEntity(Long orderId, Integer productQty, LocalDate orderDate,
			double amount, CustomerEntity customer, BasketEntity basket, Manager manager) {
		super();
		this.orderId = orderId;
		this.productQty = productQty;
		this.orderDate = orderDate;
		this.amount = amount;
		this.customer = customer;
		this.basket = basket;
		this.manager = manager;
	}




	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	public Integer getProductQty() {
		return productQty;
	}


	public void setProductQty(Integer productQty) {
		this.productQty = productQty;
	}


	public LocalDate getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public CustomerEntity getCustomer() {
		return customer;
	}


	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}


	public BasketEntity getBasket() {
		return basket;
	}


	public void setBasket(BasketEntity basket) {
		this.basket = basket;
	}


	public Manager getManager() {
		return manager;
	}


	public void setManager(Manager manager) {
		this.manager = manager;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((basket == null) ? 0 : basket.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((productQty == null) ? 0 : productQty.hashCode());
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
		ElectronicProductOrderEntity other = (ElectronicProductOrderEntity) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (basket == null) {
			if (other.basket != null)
				return false;
		} else if (!basket.equals(other.basket))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (productQty == null) {
			if (other.productQty != null)
				return false;
		} else if (!productQty.equals(other.productQty))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return String.format(
				"ElectronicProductOrderEntity [orderId=%s, productQty=%s, orderDate=%s, orderTime=%s, amount=%s, customer=%s, basket=%s, manager=%s]",
				orderId, productQty, orderDate,amount, customer, basket, manager);
	}
	
	

}