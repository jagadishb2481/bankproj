package bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bank.service.BankService;

@RestController
@RequestMapping("service/")
public class BankController {

	
	@Autowired
	BankService bankService;
	
	@GetMapping("fulFillServices")
	public String fulFullServices() {
		
		return bankService.fulFillServices();
	}
	
}
