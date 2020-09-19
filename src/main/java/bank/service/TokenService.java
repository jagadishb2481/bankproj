package bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.exception.ServiceNotFoundException;
import bank.model.Token;
import bank.repository.TokenRepository;
import bank.utls.Constants;

@Service
public class TokenService {

	@Autowired
	TokenRepository tokenRepository;
	
	@Autowired
	BankService bankService;
	
	public Integer generateToken(String service) throws ServiceNotFoundException {
		// TODO Auto-generated method stub
		Token token = new Token();
		if(bankService.isValidService(service)) {
			token.setService(service);
			token.setStatus(Constants.pending_status);
			tokenRepository.save(token);
		}
		else{
			throw new ServiceNotFoundException("Service Not Found with the name: "+service);
		}
	return token.getId();
	}

	 
}
