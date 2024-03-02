package com.luis.personal_project.entity;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.luis.personal_project.model.ProductInCart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cart {
	
	double total;
	
	Set<ProductInCart> items;
	
	
	
}
