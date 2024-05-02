package com.order.service;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order.model.ProductDto;

@FeignClient(name="PRODUCT-CATALOG-SERVICE", url="http://localhost:8001")
public interface ProductService {
	
	@GetMapping("/products/{productId}")
    public ProductDto getProductByProductId(@PathVariable Long productId);

}
