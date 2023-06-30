package com.pms.in.service;

import java.util.List;

import com.pms.in.entity.Product;

public interface ProductService {

	public Product saveProduct(Product product);
	public List<Product> getAllProducts();
	public Product getProduct(Integer pid);
	public void deleteProduct(Integer pid);
	public Product updateProduct(Integer pid,Product product);
	public List<Product> getAllProductsByName(String pname);
	
}
