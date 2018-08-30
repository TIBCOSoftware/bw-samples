package com.tibco;

import io.jaegertracing.Configuration;
import io.opentracing.Tracer;
import io.opentracing.contrib.jaxrs2.server.SpanFinishingFilter;
import io.opentracing.util.GlobalTracer;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

@WebListener
public class OpenTracingContextInitializer implements javax.servlet.ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		
		Tracer tracer = Configuration.fromEnv("Experian-Service").getTracer();

		GlobalTracer.register(tracer);

	    ServletContext servletContext = servletContextEvent.getServletContext();
	    Dynamic filterRegistration = servletContext.addFilter("tracingFilter", new SpanFinishingFilter(tracer));
	    filterRegistration.setAsyncSupported(true);
	    filterRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "*");
	}
}