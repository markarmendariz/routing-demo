package com.example.routing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@RestController
public class RoutingApplication {
	private static RoutingService service = new RoutingService();

	@RequestMapping("/")
	public Message hello() {
		return service.hello();
  	
	}
	
	@RequestMapping("/calculateSS")
	public SuitabilityScore calculateSS(@RequestParam String street, @RequestParam String driver) {
		return service.calculateSS(street, driver);
	}

	public static void main(String[] args) {
		SpringApplication.run(RoutingApplication.class, args);
	}

}
