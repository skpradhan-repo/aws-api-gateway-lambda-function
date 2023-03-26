package com.samsoft.poc.springfunction.main;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.samsoft.poc.springfunction.main.entity.Employee;
import com.samsoft.poc.springfunction.main.repository.EmployeeRepository;
import com.samsoft.poc.springfunction.main.util.EmployeeConsumer;

@SpringBootApplication
public class AwsSpringFunctionApplication {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Bean
	public Supplier<List<Employee>> getEmployees() {
		return () -> employeeRepository.employeeList();
	}

	@Bean
	public Function<String, List<Employee>> findEmployeeByName() {
		return (name) -> employeeRepository.employeeList().stream().filter(i -> i.getName().equalsIgnoreCase(name))
				.collect(Collectors.toList());
	}

	@Bean
	public Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> getAPIResponse() {
		return (req) -> {
			APIGatewayProxyResponseEvent res = new APIGatewayProxyResponseEvent();
			res.setBody(req.getBody());
			res.setStatusCode(201);
			res.setHeaders(Collections.singletonMap("Content-type:","application/json"));
			return res;
		};
	}

	@Bean
	public EmployeeConsumer employeeConsumerBean() {
		return new EmployeeConsumer();
	}

	public static void main(String[] args) {
		SpringApplication.run(AwsSpringFunctionApplication.class, args);
	}

}
