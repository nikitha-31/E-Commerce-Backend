package com.recommendation.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.recommendation.model.ProductDto;



@FeignClient(name="PRODUCT-CATALOG-SERVICE", url="http://localhost:8001")
public interface ProductService {
	
	@GetMapping("/products/{productId}")
    public ProductDto getProductByProductId(@PathVariable Long productId);
	
	@GetMapping("/products/all")
    public ResponseEntity<List<ProductDto>> getAllProducts();

}