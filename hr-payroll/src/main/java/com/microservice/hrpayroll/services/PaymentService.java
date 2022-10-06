package com.microservice.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.microservice.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(Long workerId, Integer days) {
		return new Payment("Joseph", 200D, days);
	}
}
