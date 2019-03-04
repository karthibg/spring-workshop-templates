package ch.asmiq.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.asmiq.model.Customer;
import ch.asmiq.model.Order;

public class AsmiqAcademyServiceTest {

	AsmiqAcademyService asmiqAcademyService;

	private Order order;

	@BeforeEach
	public void setUp() {
		var optJavaCourse = asmiqAcademyService.getCourses().stream().filter(p -> p.getName().contains("Java"))
				.findAny();
		if (optJavaCourse.isPresent()) {
			order = new Order();
			order.setCustomer(new Customer("karthi", "karthistr 6, 8051 Zürich"));
			order.setCourse(optJavaCourse.get());
		}
	}

	@Test
	public void placeOrder_returns_order_has_been_successfully_placed() {
		List<String> infos = asmiqAcademyService.placeOrder(order);

		assertEquals(infos.get(0), SmsService.ORDER_SUCCESS_INFO); // TODO Move the constant to AsmiqAcademyService
	}
}
