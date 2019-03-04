package ch.asmiq.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ch.asmiq.interfaces.NotificationService;
import ch.asmiq.model.Order;

@Primary
@Service
public class SmsService implements NotificationService {

	private static final Logger LOG = Logger.getLogger(SmsService.class.getName());

	public static final String ORDER_SUCCESS_INFO = "The following order has been successfully placed";

	@Override
	public List<String> sendNotification(Order order) {
		var customer = order.getCustomer();
		var course = order.getCourse();
		var customerInfo = String.format("Customer %n name: %s, address: %s", customer.getName(),
				customer.getAddress());
		var courseInfo = String.format("Course %n name: %s, price: %s, days: %s", course.getName(), course.getPrice(),
				course.getQuantity());

		List<String> notificationMessage = List.of(ORDER_SUCCESS_INFO, customerInfo, courseInfo);
		
		LOG.info(notificationMessage.toString());
		
		return notificationMessage;
	}

}
