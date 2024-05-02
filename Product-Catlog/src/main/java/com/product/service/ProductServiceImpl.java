package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product createProduct(Product product, String requestRole) throws Exception {
		if(!requestRole.equals(("Role_Admin"))) {
			throw new Exception("only admin can add product");
		}
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productRepository.findAll();
	}

	@Override
	public List<Product> getAllProductByCategory(String category) {
		
		 return productRepository.findByCategory(category);
	}

	@Override
	public Product getProductByProductId(Long productId)throws Exception {
		Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            return productOptional.get();
        } else {
            throw new Exception("Product not found");
        }
	}

	@Override
	public List<Product> getAllProductsByproductName(String productName) {
		return productRepository.findByProductNameContainingIgnoreCase(productName);
	}

	
	 @Override
	 public Product updateProduct(Long productId, Product updatedProduct, String requestRole) throws Exception {
	        // Check if the user has the required role to update products
	        if (!requestRole.equals(("Role_Admin"))) {
	            throw new Exception("Only admin can update products");
	        }

	        // Retrieve the existing product by ID
	        Optional<Product> optionalProduct = productRepository.findById(productId);
	        if (optionalProduct.isPresent()) {
	            Product existingProduct = optionalProduct.get();
	            // Update the existing product with the new data
	            existingProduct.setProductName(updatedProduct.getProductName());
	            existingProduct.setDiscription(updatedProduct.getDiscription());
	            existingProduct.setPrice(updatedProduct.getPrice());
	            existingProduct.setCategory(updatedProduct.getCategory());
	            existingProduct.setAvailability(updatedProduct.getAvailability());
	            // Save the updated product
	            return productRepository.save(existingProduct);
	        } else {
	            throw new Exception("Product not found");
	        }
	    }
	 
	@Override
    public void deleteProduct(Long productId, String requestRole) throws Exception {
        
        if (!requestRole.equals(("Role_Admin"))) {
            throw new Exception("Only admin can delete products");
        }

       
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            
            productRepository.delete(optionalProduct.get());
        } else {
            throw new Exception("Product not found");
        }
    }

}
