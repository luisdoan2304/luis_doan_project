package com.luis.personal_project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	private int id;
	private String name;
	private float price;
	private String image;
	private boolean isNew;
	private String description;
	
	// Getter
	  public boolean getIsNew() {
	    return isNew;
	  }

	  // Setter
	  public void setIsNew(boolean isNew) {
	    this.isNew = isNew;
	  }

	public Product(int id, String name, float price, String image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
	}

	public Product(int id, String name, float price, String image, boolean isNew) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.isNew = isNew;
	}

	public Product(int id, String name, float price, String image, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.description = description;
	}

	
	
	
	
	
}
