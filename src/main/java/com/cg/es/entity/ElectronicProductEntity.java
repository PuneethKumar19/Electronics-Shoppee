package com.cg.es.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.cg.es.model.ProductType;

@Entity
@Table(name="electronic_products")
public class ElectronicProductEntity {

	@Id
	@Column(name="product_id")
	private Long productId;

	@Column(name= "product_name", nullable = false)
	private String productName;

	@Column(name= "product_price", nullable = false)
	private double productPrice;

	@Column(name= "created_date", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate createdDate;
	
	@Column(name= "product_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private ProductType productType;
	
	@Transient
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="basket_id")
	private BasketEntity basket;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id")
	public CustomerEntity customer;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="manager_id")
	public Manager manager;

	
	public ElectronicProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ElectronicProductEntity(Long productId, String productName, double productPrice, LocalDate createdDate,
			ProductType productType,CustomerEntity customer, Manager manager) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.createdDate = createdDate;
		this.productType = productType;
		this.customer = customer;
		this.manager = manager;
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


	public ProductType getProductType() {
		return productType;
	}


	public void setProductType(ProductType productType) {
		this.productType = productType;
	}


//	public BasketEntity getBasket() {
//		return basket;
//	}
//
//
//	public void setBasket(BasketEntity basket) {
//		this.basket = basket;
//	}
//
	
	

	public Manager getManager() {
		return manager;
	}


	public CustomerEntity getCustomer() {
		return customer;
	}


	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}


	public void setManager(Manager manager) {
		this.manager = manager;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((basket == null) ? 0 : basket.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
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
		ElectronicProductEntity other = (ElectronicProductEntity) obj;
//		if (basket == null) {
//			if (other.basket != null)
//				return false;
//		} else if (!basket.equals(other.basket))
//			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
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
				"ElectronicProductEntity [productId=%s, productName=%s, productPrice=%s, createdDate=%s, productType=%s, basket=%s, manager=%s]",
				productId, productName, productPrice, createdDate, productType, manager);
	}	

}