package com.cg.es.model;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class ElectronicProductModel {

	@NotEmpty(message="productId  cannot be empty")
	@NotNull(message = "productId cannot be omitted")
	private Long productId;

	@NotEmpty(message="productName  cannot be empty")
	@NotNull(message = "productName cannot be omitted")
	private String productName;

	private double productPrice;

	private LocalDate createdDate;
	
	private String productType;
	
	@NotEmpty(message="customerId  cannot be empty")
	@NotNull(message = "customerId cannot be omitted")
	private Long customerId;
	
	@NotEmpty(message="managerId  cannot be empty")
	@NotNull(message = "managerId cannot be omitted")
	public Long managerId;
	
	

	public ElectronicProductModel() {
		super();
	}

	

	public ElectronicProductModel(Long productId, String productName, double productPrice, LocalDate createdDate,
			String productType, Long customerId, Long managerId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.createdDate = createdDate;
		this.productType = productType;
		this.customerId = customerId;
		this.managerId = managerId;
	}



	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

//	public Long getBasketId() {
//		return basketId;
//	}
//
//	public void setBasketId(Long basketId) {
//		this.basketId = basketId;
//	}
	
	public Long getManagerId() {
		return managerId;
	}

	public Long getCustomerId() {
		return customerId;
	}



	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}



	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((basketId == null) ? 0 : basketId.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((managerId == null) ? 0 : managerId.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(productPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
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
		ElectronicProductModel other = (ElectronicProductModel) obj;
//		if (basketId == null) {
//			if (other.basketId != null)
//				return false;
//		} else if (!basketId.equals(other.basketId))
//			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (managerId == null) {
			if (other.managerId != null)
				return false;
		} else if (!managerId.equals(other.managerId))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (Double.doubleToLongBits(productPrice) != Double.doubleToLongBits(other.productPrice))
			return false;
		if (productType != other.productType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"ElectronicProductModel [productId=%s, productName=%s, productPrice=%s, createdDate=%s, productType=%s, basketId=%s, managerId=%s]",
				productId, productName, productPrice, createdDate, productType, managerId);
	}

	
	
	
}