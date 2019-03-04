package ch.asmiq;

import java.util.Optional;
import java.util.logging.Logger;

import ch.asmiq.model.Course;
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
		AsmiqAcademyService asmiqAcademyService = new AsmiqAcademyService(courseService, smsService);

		var optJavaCourse = findFirstCourseByTopic(asmiqAcademyService, "Java");

		var karthi = new Customer("karthi", "karthistr 6, 8051 Zürich");
		var michael = new Customer("michael", "michaelstr 19, 8050 Zürich");

		placeOrder(asmiqAcademyService, optJavaCourse, karthi);
		placeOrder(asmiqAcademyService, optJavaCourse, michael);

	}

	private static void placeOrder(AsmiqAcademyService academyService, Optional<Course> optCourse, Customer customer) {

		optCourse.ifPresentOrElse(courseName -> {
			Order order = createOrder(courseName, customer);
			academyService.placeOrder(order);
		}, AsmiqAcademyApp::handleCourseNotPresent);

	}

	private static Order createOrder(Course courseName, Customer customer) {
		Order order = new Order();
		order.setCustomer(customer);
		order.setCourse(courseName);
		return order;
	}

	private static Optional<Course> findFirstCourseByTopic(AsmiqAcademyService academyService, String topic) {
		return academyService.getCourses().stream().filter(p -> p.getName().contains(topic)).findAny();
	}

	private static void handleCourseNotPresent() {
		LOG.info("No order has been placed!!");
	}

}