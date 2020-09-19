package bank.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.model.Token;
import bank.repository.TokenRepository;
import bank.utls.Constants;

@Service
public class BankService {

	
	@Autowired
	TokenRepository tokenRepository;
	
	public List<String> getServices(){
		List<String> serviceList = Stream.of("Update Passbook","Cash Deposit","Demand Draft")
				.collect(Collectors.toList());
		
		return serviceList;
	}

	public boolean isValidService(String service) {
		List<String> serviceList = getServices();
		return serviceList.contains(service);
	}
	
	public String fulFillServices() {
		
		List<String> services = getServices();
		List<Token> tokenList = tokenRepository.findByStatusOrderById(Constants.pending_status);
		LinkedHashMap<String, List<Token>> tokensByService = new LinkedHashMap<>();
		
		// tokens by Service wise
		tokenList.forEach(x->{
			if(tokensByService.containsKey(x.getService())){
			List<Token> tokens = tokensByService.get(x.getService());
			tokens.add(x);
			tokensByService.put(x.getService(), tokens);
		}
			else {
				List<Token> tknList = new ArrayList<Token>();
				tknList.add(x);
				tokensByService.put(x.getService(), tknList);
			}
			
		});
		//LinkedHashMap<String, List<Token>> tokensByService = TokenRepository.findB 
		services.forEach(x->{
		 
		});
		
		tokensByService.entrySet().parallelStream().forEach(x->{
			System.out.println("FulfilledService");
			List<Token> tokens = x.getValue();
			tokens.forEach(y->{
				y.setStatus(Constants.completed_status);
				tokenRepository.save(y);
			});
		});
		
		return "SUCCESS";
	}
	
	

	
}
