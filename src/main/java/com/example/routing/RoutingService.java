package com.example.routing;

public class RoutingService {
	public Message hello() {
		return new Message("Hello from routing demo!");
	}
	
	public SuitabilityScore calculateSS(String street, String driver) {
		return new SuitabilityScore(street + driver);
	}

}
