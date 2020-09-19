package bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bank.exception.ServiceNotFoundException;
import bank.model.Review;
import bank.model.Token;
import bank.service.BankService;
import bank.service.ReviewService;
import bank.service.TokenService;
import bank.utls.Constants;

@RestController
@RequestMapping("review/")
public class ReviewController {

	@Autowired
	TokenService tokenService;
	
	@Autowired
	BankService bankService;
	
	@Autowired
	ReviewService reviewService;
	
	@PostMapping("create")
	public Review createReview(@RequestBody Review review) throws ServiceNotFoundException {
		
		Token token = review.getToken();
		if(null!=review && null!=token && null!= token.getStatus() && token.getStatus().equals(Constants.completed_status) && 
				null!=review.getRating() && bankService.isValidService(review.getService())) {
			review  = reviewService.createReview(review);}
		else{
			throw new ServiceNotFoundException("Invalid Request: "+token.toString());
		}
		return review;
	}
	
	
	@GetMapping("avgRatingByService")
	public Double getAvgRatingByService(@RequestParam("Service") String service) throws ServiceNotFoundException {
		
		return reviewService.getAvgRatingByService(service);
	}
	
}
