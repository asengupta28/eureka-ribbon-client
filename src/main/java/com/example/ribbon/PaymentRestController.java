package com.example.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ribbon.CartRestConsumer;

@RestController
@RequestMapping("/payment")
public class PaymentRestController
{
	@Autowired
	private CartRestConsumer consumer;

	@GetMapping("/health")
	public String health()
	{
		System.out.println("***********************************\n");
		System.out.println("From PaymentRestController: I am Ok");
		System.out.println("\n***********************************");
		return "From PaymentRestController: I am Ok";
	}

	@GetMapping("/backend")
	public String getPaymentData()
	{
		System.out.println("***********************************\n");
		System.out.println("From PaymentRestController:getPaymentData()");
		System.out.println("\n***********************************");
		return "FROM PAYMENT-SERVICE : " + consumer.getCartInfo();
	}
}