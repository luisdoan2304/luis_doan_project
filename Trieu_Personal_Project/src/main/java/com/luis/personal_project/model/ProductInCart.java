package com.luis.personal_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductInCart {
	
	int id;
	String name;
	double price;
	double subTotal;
	int quantity;
	
	
	@Override
	public int hashCode() {
		
		int hashCode = 1;
		hashCode = 31 * hashCode + id;
		return hashCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		
		ProductInCart product = (ProductInCart) obj;
		
		return this.id == product.getId();
	}
}
