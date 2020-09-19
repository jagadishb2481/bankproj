package bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bank.exception.ServiceNotFoundException;
import bank.repository.TokenRepository;
import bank.service.BankService;
import bank.service.TokenService;

@RestController
@RequestMapping("/token")
public class TokenController {

	@Autowired
	TokenService tokenService;
	
	@Autowired
	BankService bankService;
	
	@GetMapping("/")
	public String home(){
		return "Hello world";
	}
	
	@PostMapping("/generate")
	public Integer generateToken(String service) throws ServiceNotFoundException{
		Integer token = null;
		if(bankService.isValidService(service)) {
			 token = tokenService.generateToken(service);}
		else{
			throw new ServiceNotFoundException("Service Not Found with the name: "+service);
		}
		return token;
	}
	
}
