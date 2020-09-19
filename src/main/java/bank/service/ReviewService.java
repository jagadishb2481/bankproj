package bank.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.exception.ServiceNotFoundException;
import bank.model.Review;
import bank.model.Token;
import bank.repository.ReviewRepository;
import bank.repository.TokenRepository;
import bank.utls.Constants;

@Service
public class ReviewService {

	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	TokenRepository tokenRepository;
	
	@Autowired
	BankService bankService;
	

	public Review createReview(Review review) throws ServiceNotFoundException {
		// TODO Auto-generated method stub
		
		Token token = review.getToken();
		
		if(null!=review && null!=token && null!= token.getStatus() && token.getStatus().equals(Constants.completed_status) && 
				null!=review.getRating() && bankService.isValidService(review.getService())) {
			review = reviewRepository.save(review);}
		else{
			throw new ServiceNotFoundException("Invalid Request: "+review.toString());
		}
		
		
		return review;
	}

	public Double getAvgRatingByService(String service) throws ServiceNotFoundException {
		// TODO Auto-generated method stub
		Double average = null;
		if(bankService.isValidService(service)){
			List<Review> reviewList = reviewRepository.findByService(service);
			if(reviewList!=null && reviewList.size()>0) {
				average = reviewList.stream().mapToDouble(x-> x.getRating()).average().getAsDouble();
			}
		}else{
			throw new ServiceNotFoundException("Service Not Found with the name: "+service);
		}
		
		return average;
	}
	
	
}
