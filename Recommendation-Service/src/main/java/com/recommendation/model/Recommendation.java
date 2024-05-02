package com.recommendation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "recommendation")
public class Recommendation {
	
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int rating;
    
    private long productId;
    
   
    
    private long userId;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public int getRating() {
		return rating;
	}



	public void setRating(int rating) {
		this.rating = rating;
	}



	public long getProductId() {
		return productId;
	}



	public void setProductId(long productId) {
		this.productId = productId;
	}



	public long getUserId() {
		return userId;
	}



	public void setUserId(long userId) {
		this.userId = userId;
	}



	public Recommendation(Long id, int rating, long productId, long userId) {
		super();
		this.id = id;
		this.rating = rating;
		this.productId = productId;
		this.userId = userId;
	}



	public Recommendation() {
		super();
	}
    
    

}