package ch.asmiq.interfaces;

import ch.asmiq.model.Order;

public interface PaymentService {

	void doPay(Order order);
}
