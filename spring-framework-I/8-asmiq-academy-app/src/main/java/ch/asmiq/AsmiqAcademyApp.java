package ch.asmiq;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import ch.asmiq.model.Course;
import ch.asmiq.model.Customer;
import ch.asmiq.model.Order;
import ch.asmiq.service.AsmiqAcademyService;

@ComponentScan("ch.asmiq")
public class AsmiqAcademyApp {

	private static final Logger LOG = Logger.getLogger(AsmiqAcademyApp.class.getName());
	
	private static final List<BiConsumer<AsmiqAcademyService, Order>> orderExecutions = List.of(AsmiqAcademyService::placeOrder, AsmiqAcademyService::downloadCertificate);

	public static void main(final String[] args) {

		final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				AsmiqAcademyApp.class);
		final AsmiqAcademyService asmiqAcademyService = applicationContext.getBean(AsmiqAcademyService.class);

		final var optJavaCourse = findFirstCourseByTopic(asmiqAcademyService, "Java");

		final var karthi = new Customer("karthi", "karthistr 6, 8051 Zürich");
		final var michael = new Customer("michael", "michaelstr 19, 8053 Zürich");

		executeOrderFor(karthi, optJavaCourse, asmiqAcademyService);
		executeOrderFor(michael, optJavaCourse, asmiqAcademyService);

		applicationContext.close();

	}

	private static void executeOrderFor(final Customer customer, final Optional<Course> optCourse,
			final AsmiqAcademyService academyService) {

		optCourse.ifPresentOrElse(courseName -> {
			final Order order = createOrder(courseName, customer);
			orderExecutions.forEach(oe -> oe.accept(academyService, order));
		}, AsmiqAcademyApp::handleCourseNotPresent);

	}

	private static Order createOrder(final Course courseName, final Customer customer) {
		final var order = new Order();
		order.setCustomer(customer);
		order.setCourse(courseName);
		return order;
	}

	private static Optional<Course> findFirstCourseByTopic(final AsmiqAcademyService academyService,
			final String topic) {
		return academyService.getCourses().stream().filter(p -> p.getName().contains(topic)).findAny();
	}

	private static void handleCourseNotPresent() {
		LOG.info("No order has been placed!!");
	}

}