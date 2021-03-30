
package com.cg.es.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class BasketModel {

	@NotEmpty(message="basketId  cannot be empty")
	@NotNull(message="basketId cannot be omitted")
	private Long basketId;
	

	@NotEmpty(message="total  cannot be empty")
	@NotNull(message="total cannot be omitted")
	private Double grandTotal;
	
	private Integer quantityOfProduct;
	
	private Long customerId;


	public BasketModel() {
		
	}
	
	

	public BasketModel(
			@NotEmpty(message = "basketId  cannot be empty") @NotNull(message = "basketId cannot be omitted") Long basketId,
			@NotEmpty(message = "total  cannot be empty") @NotNull(message = "total cannot be omitted") Double grandTotal,
			Integer quantityOfProduct, Long customerId) {
		super();
		this.basketId = basketId;
		this.grandTotal = grandTotal;
		this.quantityOfProduct = quantityOfProduct;
		this.customerId = customerId;
	}



	public Integer getQuantityOfProduct() {
		return quantityOfProduct;
	}



	public void setQuantityOfProduct(Integer quantityOfProduct) {
		this.quantityOfProduct = quantityOfProduct;
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

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((basketId == null) ? 0 : basketId.hashCode());
		result = prime * result + ((grandTotal == null) ? 0 : grandTotal.hashCode());
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
		BasketModel other = (BasketModel) obj;
		if (basketId == null) {
			if (other.basketId != null)
				return false;
		} else if (!basketId.equals(other.basketId))
			return false;
		if (grandTotal == null) {
			if (other.grandTotal != null)
				return false;
		} else if (!grandTotal.equals(other.grandTotal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("BasketModel [basketId=%s, grandTotal=%s]", basketId, grandTotal);
	}
	
	
	
}
