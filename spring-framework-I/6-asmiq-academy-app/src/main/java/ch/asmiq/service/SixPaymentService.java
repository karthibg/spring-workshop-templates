package ch.asmiq.service;

import org.springframework.stereotype.Service;

import ch.asmiq.interfaces.PaymentService;
import ch.asmiq.model.Order;

@Service
public class SixPaymentService implements PaymentService {

	@Override
	public void doPay(Order order) {
		System.out.println("paid");
	}

	

}
