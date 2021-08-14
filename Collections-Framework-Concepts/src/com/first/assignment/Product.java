package com.first.assignment;

import java.util.Iterator;

public class Product {

	private String productId;
	private String productName;
		
	public Product(String productId, String productName) {
		this.productId = productId;
		this.productName = productName;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	
}
