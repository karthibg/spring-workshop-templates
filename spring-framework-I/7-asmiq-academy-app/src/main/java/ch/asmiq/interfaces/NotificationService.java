package ch.asmiq.interfaces;

import java.util.List;

import ch.asmiq.model.Order;

public interface NotificationService {

	List<String> sendNotification(Order order);

}
