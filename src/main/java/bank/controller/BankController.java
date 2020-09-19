package bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import bank.service.BankService;

@RestController
public class BankController {

	
	@Autowired
	BankService bankService;
	
	@GetMapping("fulFillServices")
	public String fulFullServices() {
		
		return bankService.fulFillServices();
	}
	
}
