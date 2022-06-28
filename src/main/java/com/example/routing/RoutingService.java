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

	private String calculateScore(String street, String driver) {
		double score = 0.0;
		
		// Rule #1 - destination street name length is even	
		if(street.length() % 2 == 0) {
			score = (double) numberOfVowels(driver) * 1.5;
		}
		// Rule #2 - destination street name length is odd
		else {
			score = (double)(street.length() -  numberOfVowels(driver)) * 1.0 ;
		}
		
		// Rule #3
		if(street.length() > 1 && street.length() == driver.length()) {
			score = score * 1.5;
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
