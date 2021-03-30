package com.cg.es.model;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class ElectronicProductOrderModel {

	@NotEmpty(message="orderId  cannot be empty")
	@NotNull(message = "orderId cannot be omitted")
	private Long orderId;
	
	private Integer productQty;
	
	private LocalDate orderDate;

	private double amount;

	@NotEmpty(message="customerId  cannot be empty")
	@NotNull(message = "customerId cannot be omitted")
	private Long customerId;
	
	@NotEmpty(message="basketId  cannot be empty")
	@NotNull(message = "basketId cannot be omitted")
	private Long basketId;
	
	@NotEmpty(message="managerId  cannot be empty")
	@NotNull(message = "managerId cannot be omitted")
	private Long managerId;
	
	public ElectronicProductOrderModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ElectronicProductOrderModel(Long orderId, Integer productQty, LocalDate orderDate,
			double amount, Long customerId, Long basketId, Long managerId) {
		super();
		this.orderId = orderId;
		this.productQty = productQty;
		this.orderDate = orderDate;
		this.amount = amount;
		this.customerId = customerId;
		this.basketId = basketId;
		this.managerId = managerId;
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

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getBasketId() {
		return basketId;
	}

	public void setBasketId(Long basketId) {
		this.basketId = basketId;
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
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((basketId == null) ? 0 : basketId.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((managerId == null) ? 0 : managerId.hashCode());
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
		ElectronicProductOrderModel other = (ElectronicProductOrderModel) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (basketId == null) {
			if (other.basketId != null)
				return false;
		} else if (!basketId.equals(other.basketId))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (managerId == null) {
			if (other.managerId != null)
				return false;
		} else if (!managerId.equals(other.managerId))
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
				"ElectronicProductOrderModel [orderId=%s, productQty=%s, orderDate=%s, orderTime=%s, amount=%s, customerId=%s, basketId=%s, managerId=%s]",
				orderId, productQty, orderDate, amount, customerId, basketId, managerId);
	}

		

}