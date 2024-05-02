package com.product.service;


import com.product.model.Product;

import java.util.*;

public interface ProductService {
	
	
	
	Product createProduct(Product product, String requestRole)throws Exception;
	
	List<Product> getAllProduct();
	
	List<Product> getAllProductByCategory(String category);
	Product getProductByProductId(Long productId)throws Exception;
	List<Product> getAllProductsByproductName(String productName);
	
	void deleteProduct(Long productId, String requestRole)throws Exception;

	Product updateProduct(Long productId, Product updatedProduct, String requestRole) throws Exception;

}
