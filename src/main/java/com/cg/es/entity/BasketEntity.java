package com.cg.es.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="basket")
public class BasketEntity {

	@Id
	@Column(name="basket_id")
	private Long basketId;
	
	@Column(name="total_products")
	private Integer quantityOfProduct;
	
	@Column(name="total_amount")
	private Double grandTotal;
	
	@OneToMany(mappedBy="basket")
	private List<ElectronicProductOrderEntity> electronicProductorders;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private CustomerEntity customer;
	
	

	public BasketEntity() {
		
	}
	

	public BasketEntity(Long basketId, Integer quantityOfProduct, Double grandTotal, CustomerEntity customer) {
		super();
		this.basketId = basketId;
		this.quantityOfProduct = quantityOfProduct;
		this.grandTotal = grandTotal;
		this.customer = customer;
	}


	public Integer getQuantityOfProduct() {
		return quantityOfProduct;
	}


	public void setQuantityOfProduct(Integer quantityOfProduct) {
		this.quantityOfProduct = quantityOfProduct;
	}


	public List<ElectronicProductOrderEntity> getElectronicProductorders() {
		return electronicProductorders;
	}


	public void setElectronicProductorders(List<ElectronicProductOrderEntity> electronicProductorders) {
		this.electronicProductorders = electronicProductorders;
	}


	public CustomerEntity getCustomer() {
		return customer;
	}


	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}


	public Long getBasketId() {
		return basketId;
	}

	public void setBasketId(Long basketId) {
		this.basketId = basketId;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public List<ElectronicProductOrderEntity> getElectronicProducts() {
		return electronicProductorders;
	}

	public void setElectronicProducts(List<ElectronicProductOrderEntity> electronicProductorders) {
		this.electronicProductorders = electronicProductorders;
	}

	@Override
	public String toString() {
		return String.format("BasketEntity [basketId=%s, grandTotal=%s, electronicProducts=%s]", basketId, grandTotal,
				electronicProductorders);
	}

}
