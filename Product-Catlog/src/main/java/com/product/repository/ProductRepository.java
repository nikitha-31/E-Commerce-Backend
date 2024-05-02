package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findByCategory(String category);
	
	 List<Product> findByProductNameContainingIgnoreCase(String productName);

}
