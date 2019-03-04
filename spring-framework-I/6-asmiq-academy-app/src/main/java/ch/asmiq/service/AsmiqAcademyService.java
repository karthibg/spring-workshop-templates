package ch.asmiq.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import ch.asmiq.interfaces.CertificationService;
import ch.asmiq.interfaces.CourseService;
import ch.asmiq.interfaces.ExamService;
import ch.asmiq.interfaces.FeedbackService;
import ch.asmiq.interfaces.NotificationService;
import ch.asmiq.interfaces.PaymentService;
import ch.asmiq.model.Course;
import ch.asmiq.model.Order;

@Service
public class AsmiqAcademyService {

	private CourseService courseService;
	private NotificationService notificationService;
	private PaymentService paymentService;
	private FeedbackService feedBackService;
	private ExamService examService;
	private CertificationService certificationService;

	public List<Course> getCourses() {
		//TODO
		//return courseService.getCourses();
		return Collections.emptyList();
	}

	public void placeOrder(Order order) {
		//TODO
		//notificationService.sendNotification(order);
	}

	public void downloadCertificate(Order order) {
		//TODO
		//certificationService.downloadCertificate(order);
	}

}
