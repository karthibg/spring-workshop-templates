package ch.asmiq.service;

import org.springframework.stereotype.Service;

import ch.asmiq.interfaces.CertificationService;
import ch.asmiq.model.Order;

@Service
public class AsmiqCertificationService implements CertificationService {

	public void downloadCertificate(Order order) {
		System.out.println("certificate downloaded");
	}
}
