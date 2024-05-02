package com.recommendation.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.recommendation.model.ProductDto;
import com.recommendation.model.Recommendation;
import com.recommendation.repository.RecommendationRepository;

@Service
public class RecommendationServiceImpl implements RecommendationService {


	@Autowired
	private RecommendationRepository recommendationRepository;
	@Autowired
	private ProductService productService;
	
	@Override
	public Recommendation makeRecommendation(Long productId, Long userId, int rating) throws Exception {
		ProductDto product=productService.getProductByProductId(productId);
		if(product!=null) {
			Recommendation recommed=new Recommendation();
			recommed.setProductId(productId);
			recommed.setRating(rating);
			recommed.setUserId(userId);
			return recommendationRepository.save(recommed);
		}
		throw new Exception("product not found by id"+productId);
		
	}

	@Override
	public List<Recommendation> getRecommendationsSortedByRating() {
		return recommendationRepository.findAllByOrderByRatingDesc();
		
	}

}
