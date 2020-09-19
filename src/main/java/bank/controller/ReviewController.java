package bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bank.exception.ServiceNotFoundException;
import bank.model.Review;
import bank.service.BankService;
import bank.service.ReviewService;
import bank.service.TokenService;

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
		
		if(null!=review && null!= review.getService() && null!=review.getRating() && bankService.isValidService(review.getService())) {
			review  = reviewService.createReview(review);}
		else{
			throw new ServiceNotFoundException("Invalid Request: "+review.toString());
		}
		return review;
	}
	
}
