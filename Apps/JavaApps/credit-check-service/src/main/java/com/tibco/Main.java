package com.tibco;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import io.jaegertracing.Configuration;
import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;

import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 *
 */
public class Main {
	// Base URI the Grizzly HTTP server will listen on
	public static final String BASE_URI = "http://0.0.0.0:7080/";

	/**
	 * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
	 * application.
	 * 
	 * @return Grizzly HTTP server.
	 */
	public static HttpServer startServer() {
		// create a resource config that scans for JAX-RS resources and
		// providers
		// in com.tibco package

		// create and start a new instance of grizzly http server
		// exposing the Jersey application at BASE_URI
		return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI),
				new ExperianApplication());
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		final HttpServer server = startServer();

		Tracer tracer = Configuration.fromEnv("Experian-Service").getTracer();

		GlobalTracer.register(tracer);
		
		if(!server.isStarted()){
			server.start();
		}
		
		System.out.println("Registered Global Tracer :" + tracer.toString());
		System.out.println(String.format(
				"Jersey app started available at "+ BASE_URI));
	}
}
