package ch.asmiq.service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import ch.asmiq.interfaces.PaymentService;
import ch.asmiq.model.Order;

@Service
public class SixPaymentService implements PaymentService {

	private static final Logger LOG = Logger.getLogger(SixPaymentService.class.getName());
	
	private BigDecimal discountPercent = new BigDecimal("0.25");
	
	@Override
	public void doPay(Order order) {
		BigDecimal coursePrice = order.getCourse().getPrice();
		BigDecimal discountPrice = coursePrice.multiply(discountPercent);
		BigDecimal totalPrice = coursePrice.subtract(discountPrice);
		LOG.info("Total amount paid :" + NumberFormat.getInstance().format(totalPrice));
	}


	

}
