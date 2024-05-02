package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Product;
import com.product.model.UserDto;
import com.product.service.ProductService;
import com.product.service.UserService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add/product")
	private ResponseEntity<Product> createProduct(@RequestBody Product product, @RequestHeader("Authorization") String jwt)throws Exception{
		
		UserDto user=userService.getUserProfile(jwt);
		
		Product createdProduct= productService.createProduct(product,user.getRole());
		return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
	}
	
	@GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProduct();
        return ResponseEntity.ok(products);
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Product>> getAllProductsByCategory(@PathVariable String category) {
        List<Product> products = productService.getAllProductByCategory(category);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProductByProductId(@PathVariable Long productId) {
        try {
            Product product = productService.getProductByProductId(productId);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No product found");
        }
    }

    @GetMapping("/search/{productName}")
    public ResponseEntity<?> getAllProductsByProductName(@PathVariable String productName) {
        List<Product> products = productService.getAllProductsByproductName(productName);
        if (products.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No products found for the given name: " + productName);
        } else {
            return ResponseEntity.ok(products);
        }
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable Long productId, @RequestBody Product updatedProduct, @RequestHeader("Authorization") String jwt) throws Exception {
    	
    	UserDto user=userService.getUserProfile(jwt);
    	
    	Product product = productService.updateProduct(productId, updatedProduct,user.getRole());
    	return ResponseEntity.ok(product);
    	
    
    }
    
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId, @RequestHeader("Authorization") String jwt) throws Exception {
    	UserDto user=userService.getUserProfile(jwt);
    	
    	productService.deleteProduct(productId,user.getRole());
    	return ResponseEntity.ok("Product deleted successfully");
    }
}
