package bank.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public Review createReview(Review review) {
		// TODO Auto-generated method stub
		
		review = reviewRepository.save(review);
		return review;
	}
	
	
	
	

	
}
