package com.order.model;

public class ProductDto {
	
	private Long productId;
    
	   
    private String productName;

    private String image;
    
    private double price;

    
    private String discription;

    
    private String category;

    
    private int availability;


	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getDiscription() {
		return discription;
	}


	public void setDiscription(String discription) {
		this.discription = discription;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getAvailability() {
		return availability;
	}


	public void setAvailability(int availability) {
		this.availability = availability;
	}


	public ProductDto(Long productId, String productName, String image, double price, String discription,
			String category, int availability) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.image = image;
		this.price = price;
		this.discription = discription;
		this.category = category;
		this.availability = availability;
	}


	public ProductDto() {
		super();
	}

    

}
