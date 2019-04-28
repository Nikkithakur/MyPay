package com.practice.mypay.paymentsservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.practice.mypay.paymentservices.model.Customer;

@RestController
public class PaymentController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/paymentServices/makePayment/{benefactor}/{beneficiary}/{amount}")
	public Customer makePayment(@PathVariable("benefactor") final String number1,@PathVariable("beneficiary") final String number2,@PathVariable("amount") final BigDecimal amount)
	{
		String url ="http://db-service/db/makePayment/"+number1+"/"+number2+"/"+amount;
		return restTemplate.getForObject(url, Customer.class);
	}
	
}