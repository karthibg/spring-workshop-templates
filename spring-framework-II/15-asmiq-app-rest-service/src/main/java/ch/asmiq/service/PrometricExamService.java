package ch.asmiq.service;

import org.springframework.stereotype.Service;

import ch.asmiq.interfaces.ExamService;
import ch.asmiq.model.Order;

@Service
public class PrometricExamService implements ExamService{

	@Override
	public void conductExam(Order order) {
		System.out.println("conduct exam");
	}

}
