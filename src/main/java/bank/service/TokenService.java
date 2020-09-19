package bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.model.Token;
import bank.repository.TokenRepository;
import bank.utls.Constants;

@Service
public class TokenService {

	@Autowired
	TokenRepository tokenRepository;
	
	public Integer generateToken(String service) {
		// TODO Auto-generated method stub
		
		Token token = new Token();
		token.setService(service);
		token.setStatus(Constants.pending_status);
		tokenRepository.save(token);
		
		return token.getId();
	}

	 
}
