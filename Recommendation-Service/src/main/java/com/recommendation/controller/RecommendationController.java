package com.recommendation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recommendation.model.ProductDto;
import com.recommendation.model.Recommendation;
import com.recommendation.model.UserDto;
import com.recommendation.service.ProductService;
import com.recommendation.service.RecommendationServiceImpl;
import com.recommendation.service.UserService;


@RestController
@RequestMapping("/recommend")
public class RecommendationController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private RecommendationServiceImpl recommendationService;
	
	@PostMapping("/make/recommendation")
	public ResponseEntity<Recommendation> makeRecommendation(
			@RequestParam Long productId,
			@RequestParam int rating,
			@RequestHeader ("Authorization") String jwt
			)throws Exception{
		UserDto user=userService.getUserProfile(jwt);
		ProductDto product=productService.getProductByProductId(productId);
		Recommendation recommed=recommendationService.makeRecommendation(product.getProductId(),user.getId(), rating);
		return new ResponseEntity<>(recommed, HttpStatus.CREATED);
	}
	

	 @GetMapping("/all/recommendations")
	    public ResponseEntity<List<ProductDto>> getRecommendationsSortedByRating() {
	        List<Recommendation> recommendations = recommendationService.getRecommendationsSortedByRating();

	        List<ProductDto> products = recommendations.stream()
	                .map(recommendation -> productService.getProductByProductId(recommendation.getProductId()))
	                .collect(Collectors.toList());

	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }
}