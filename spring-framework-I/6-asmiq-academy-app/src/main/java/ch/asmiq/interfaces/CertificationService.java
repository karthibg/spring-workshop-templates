package ch.asmiq.interfaces;

import ch.asmiq.model.Order;

public interface CertificationService {

	void downloadCertificate(Order order);
}
