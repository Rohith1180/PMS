package com.pms.in.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.in.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

	// Fetch all Products based on product name
	
	List<Product> findByPname(String pname);
	
	//Employee findByEmail(String email);
	
}
