package com.gpcoder.config;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.jersey.logging.LoggingFeature;
//Deployment of a JAX-RS application using @ApplicationPath with Servlet 3.0
//Descriptor-less deployment
import org.glassfish.jersey.server.ResourceConfig;

public class JerseyServletContainerConfig extends ResourceConfig {
	public JerseyServletContainerConfig() {
		// if there are more than two packages then separate them with semicolon
		packages("com.gpcoder.api");
		register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), Level.INFO,
				LoggingFeature.Verbosity.PAYLOAD_ANY, 10000));
	}
}