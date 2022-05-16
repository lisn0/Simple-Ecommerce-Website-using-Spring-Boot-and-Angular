package com.store.ecommerce.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "categories")				
@TypeAlias(value = "Category")
public class Category implements Serializable {
	@Id
    private String id;
		
    private String name;

    @DBRef(lazy = true)
    private List<Product> productsOfCategory = new ArrayList<>();

    public Category()
    {
    }	

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Product> getProductsOfCategory() {
		return productsOfCategory;
	}

	public void setProductsOfCategory(List<Product> productsOfCategory) {
		this.productsOfCategory = productsOfCategory;
	}

	public Category(String name)
    {
        this.name = name;
    }
}
