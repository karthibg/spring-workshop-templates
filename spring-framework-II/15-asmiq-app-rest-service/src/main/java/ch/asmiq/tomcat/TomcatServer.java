package ch.asmiq.tomcat;

import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

public class TomcatServer {

	private static final Logger LOG = Logger.getLogger(TomcatServer.class.getName());

	private TomcatServer() {
	}

	public static void startTomcat() {
		final Tomcat tomcat = new Tomcat();
		final Connector connector = new Connector();
		tomcat.setConnector(connector);
		connector.setPort(8080);
		tomcat.addWebapp("", Paths.get(".").toAbsolutePath().toString());
		try {
			tomcat.start();
			LOG.log(Level.INFO, "tomcat started successfully!");
		} catch (LifecycleException e) {
			LOG.log(Level.SEVERE, "tomcat not started", e);
		}
	}
}
