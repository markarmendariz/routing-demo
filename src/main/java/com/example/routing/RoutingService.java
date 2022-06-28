// routing-demo service

package com.example.routing;

public class RoutingService {
	public Message hello() {
		return new Message("Hello from routing demo!");
	}
	
	public SuitabilityScore calculateSS(String street, String driver) {
		String score = calculateScore(street, driver);
		return new SuitabilityScore(score);
	}

	/*
	   The top-secret algorithm is:
		- (Rule #1) If the length of the shipment's destination street name is even, the base suitability
		  score (SS) is the number of vowels in the driver’s name multiplied by 1.5.
		- (Rule #2) If the length of the shipment's destination street name is odd, the base SS is the
		  number of consonants in the driver’s name multiplied by 1.
		- (Rule #3) If the length of the shipment's destination street name shares any common factors
		  (besides 1) with the length of the driver’s name, the SS is increased by 50% above the
		   base SS.
	
	  Assumptions:
		- Rule #3 only fires if there more than one common length factors.
		- Rule #3 common factors are compounded.
		- Vowels consist of the characters 'a', 'e', 'i', 'o', and 'u'.
		
	 */
	private String calculateScore(String street, String driver) {
		double score = 0.0;
		
		// Rule #1 - destination street name length is even	
		if(street.length() % 2 == 0) {
			score = (double) numberOfVowels(driver) * 1.5;
		}
		// Rule #2 - destination street name length is odd
		else {
			score = (double)(driver.length() -  numberOfVowels(driver)) * 1.0 ;
		}
		
		// Rule #3 - more than one common length factors
		int commonFactors = 0;
		if(street.length() == driver.length()) {
			commonFactors += 1;
		}
		
		if(numberOfVowels(street) == numberOfVowels(driver)) {
			commonFactors += 1;
		}
		
		int streetNumOfConsonants = street.length() - numberOfVowels(street);
		int drivertNumOfConsonants = driver.length() - numberOfVowels(driver);
		
		if(streetNumOfConsonants == drivertNumOfConsonants) {
			commonFactors += 1;
		}
		
		if(commonFactors > 1) {
			score *= 1.5;
		}
		
		return Double.valueOf(score).toString();
	}
	
	private int numberOfVowels(String str) {
		int count = 0;
		for(int i=0; i<str.length(); i++) {
			if(Character.toLowerCase(str.charAt(i)) == 'a'|| Character.toLowerCase(str.charAt(i)) == 'e'|| 
					Character.toLowerCase(str.charAt(i)) == 'i' || Character.toLowerCase(str.charAt(i)) == 'o' ||
					Character.toLowerCase(str.charAt(i)) == 'u') {
				
				count += 1;
			}
		}
		
		return count;
	}
}
