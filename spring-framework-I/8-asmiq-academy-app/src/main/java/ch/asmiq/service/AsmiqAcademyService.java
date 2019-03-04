package ch.asmiq.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
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

	private static final Logger LOG = Logger.getLogger(AsmiqAcademyService.class.getName());

	private CourseService courseService;
	private NotificationService notificationService;
	private PaymentService paymentService;
	private FeedbackService feedBackService;
	private ExamService examService;
	private CertificationService certificationService;

	@Autowired
	public void setCourseService(final CourseService courseService) {
		this.courseService = courseService;
	}

	@Autowired
	public void setNotificationService(final NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	@Autowired
	public void setPaymentService(final PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@Autowired
	public void setFeedBackService(final FeedbackService feedBackService) {
		this.feedBackService = feedBackService;
	}

	@Autowired
	public void setExamService(final ExamService examService) {
		this.examService = examService;
	}

	@Autowired(required = false)
	public void setCertificationService(final CertificationService certificationService) {
		this.certificationService = certificationService;
	}

	public Optional<CertificationService> getCertificationService() {
		return Optional.ofNullable(certificationService);
	}

	// ------------------------------------------------------------------------------------------------------

	public List<Course> getCourses() {
		return courseService.getCourses();
	}

	public void placeOrder(final Order order) {
		notificationService.sendNotification(order);
		paymentService.doPay(order);
	}

	public void downloadCertificate(final Order order) {

		getCertificationService().ifPresentOrElse(cs -> cs.downloadCertificate(order),
				() -> LOG.info("Certification Service NOT Available!"));

	}
}
