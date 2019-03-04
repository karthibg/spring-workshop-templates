package ch.asmiq;

import java.util.logging.Logger;

import ch.asmiq.model.Customer;
import ch.asmiq.model.Order;
import ch.asmiq.service.AsmiqAcademyService;
import ch.asmiq.service.CourseService;
import ch.asmiq.service.SmsService;

public class AsmiqAcademyApp {

	private static final Logger LOG = Logger.getLogger(AsmiqAcademyApp.class.getName());

	public static void main(String[] args) {
		CourseService courseService = new CourseService();
		SmsService smsService = new SmsService();
		AsmiqAcademyService academyService = new AsmiqAcademyService(courseService, smsService);
		var optJavaCourse = academyService.getCourses().stream().filter(p -> p.getName().contains("Java")).findAny();

		if (optJavaCourse.isPresent()) {
			Order order = new Order();
			order.setCustomer(new Customer("karthi", "karthistr 6, 8051 Zürich"));
			order.setCourse(optJavaCourse.get());
			academyService.placeOrder(order);
		} else {
			LOG.info("No order has been placed!!");
		}
	}
}
