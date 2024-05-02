package com.recommendation.service;




import java.util.List;

import com.recommendation.model.Recommendation;

public interface RecommendationService {
	
	Recommendation makeRecommendation(Long productId, Long userId,int rating)throws Exception;
	
	List<Recommendation> getRecommendationsSortedByRating();

}
