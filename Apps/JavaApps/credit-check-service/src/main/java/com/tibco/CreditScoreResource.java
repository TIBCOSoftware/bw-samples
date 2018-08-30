package com.tibco;

import io.opentracing.Span;
import io.opentracing.util.GlobalTracer;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.opentracing.Traced;

import com.tibco.model.RequestJson;
import com.tibco.model.CreditScore;
import com.tibco.utils.RandomScore;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("creditscore")
@Traced(operationName="getCreditScore")
public class CreditScoreResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public CreditScore getIt() {
		Span childSpan = GlobalTracer.get().buildSpan("getCreditScore").start();
		CreditScore returnValue = RandomScore.generate();
		childSpan.finish();
		return returnValue;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CreditScore getCreditHistory(RequestJson request) {
		if (RandomScore.scores.size() == 0) {
			RandomScore.initializeScores();
		}

		String ssn = request.getSSN();
		//TODO Get Score based on SSN

		return RandomScore.generate();
	}

}
