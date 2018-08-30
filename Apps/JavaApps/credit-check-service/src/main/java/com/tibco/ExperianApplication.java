package com.tibco;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class ExperianApplication extends ResourceConfig {

	public ExperianApplication(){
		packages("com.tibco");
		register(org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpContainerProvider.class);
		register(JacksonFeature.class);
	}
}
