package com.tdtc.consul.controller;

import java.time.Duration;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tdtc.consul.feign.UserDetailsImpl;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.retry.Retry;

@RestController
public class Springcloud_consul_Controller {
	@Autowired
	UserDetailsImpl findAllClient;
	
	// Create a custom configuration for a CircuitBreaker
	CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
	    .failureRateThreshold(50)
	    .waitDurationInOpenState(Duration.ofMillis(1000))
	    .ringBufferSizeInHalfOpenState(2)
	    .ringBufferSizeInClosedState(2)
	    .build();

	CircuitBreaker circuitBreaker = CircuitBreaker.of("myCB1", circuitBreakerConfig);

	// Create a Retry with at most 3 retries and a fixed time interval between retries of 500ms
	Retry retry = Retry.ofDefaults("myCB1");
	
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public String getUserAll() {
		
		// Decorate your call to BackendService.doSomething() with a CircuitBreaker
		Supplier<String> decoratedSupplier = CircuitBreaker
		    .decorateSupplier(circuitBreaker, findAllClient::findAll);

		// Decorate your call with automatic retry
		decoratedSupplier = Retry
		    .decorateSupplier(retry, decoratedSupplier);
		
		//return findAllClient.findAll();
		return circuitBreaker.executeSupplier(findAllClient::findAll);
	}
}
