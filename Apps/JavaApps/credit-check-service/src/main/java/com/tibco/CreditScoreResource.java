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

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CreditScore getCreditHistory(RequestJson request) {
		if (RandomScore.scores.size() == 0) {
			RandomScore.initializeScores();
		}

		String ssn = request.getSSN();
		CreditScore score = new CreditScore();
		String lastCharSSN = ssn.substring(ssn.length()-1);

		switch (lastCharSSN){
			case "0": 
			score.setFiCOScore(200);
			score.setNoOfInquiries(10);
			score.setRating("POOR");
			break;
			case "4":
			score.setFiCOScore(400);
			score.setNoOfInquiries(8);
			score.setRating("Average");
			break;
			case "6":
			score.setFiCOScore(600);
			score.setNoOfInquiries(4);
			score.setRating("Good");
			break;
			case "9":
			score.setFiCOScore(900);
			score.setNoOfInquiries(2);
			score.setRating("EXCELLENT");
			break;
			default:
			System.out.println("Generating Random Reply");
			score = RandomScore.generate();
		}
		return score;
	}

}
