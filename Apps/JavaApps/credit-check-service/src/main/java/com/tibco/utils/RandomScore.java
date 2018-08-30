package com.tibco.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tibco.model.CreditScore;

public class RandomScore {
	
	private static final Random RND = new Random();
	public static List<CreditScore> scores = new ArrayList<>();

	public static CreditScore generate(){
		if (scores.size() < 1){
			initializeScores();
		}
		return scores.get(RND.nextInt(scores.size()));
		
	}

	public static void initializeScores() {
		CreditScore poor = new CreditScore();
		poor.setFiCOScore(200);
		poor.setNoOfInquiries(10);
		poor.setRating("POOR");
		
		CreditScore average = new CreditScore();
		average.setFiCOScore(400);
		average.setNoOfInquiries(6);
		average.setRating("Average");
		
		CreditScore good = new CreditScore();
		good.setFiCOScore(700);
		good.setNoOfInquiries(4);
		good.setRating("GOOD");
		
		CreditScore excellent = new CreditScore();
		excellent.setFiCOScore(900);
		excellent.setNoOfInquiries(2);
		excellent.setRating("Excellent");
		
		scores.add(excellent);
		scores.add(good);
		scores.add(average);
		scores.add(poor);
		
		
	}

}
