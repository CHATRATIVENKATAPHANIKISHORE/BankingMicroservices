package com.gateway.BankApiGate;

import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ApiRoute {
	 @Bean
	    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
	        return builder.routes()
	            // Route for /data
	            .route(r -> r.path("/data")
	                .uri("http://localhost:8081/data/**"))
	            
	            // Route for /login
	            .route(r -> r.path("/login")
	                .uri("http://adminservice:8080"))
	            
	            // Route for /ui
	            .route(r -> r.path("/ui")
	                .uri("http://adminui:8080"))

	            // Route for /cui
	            .route(r -> r.path("/cui")
	                .uri("http://customerui:8080"))

	            // Route for /customer
	            .route(r -> r.path("/customer")
	                .uri("http://customer:8080"))

	            // Redirect /login/validated to /customer
	            .route(r -> r.path("/login/validated")
	                .filters(f -> f.rewritePath("/login/validated", "/customer"))
	                .uri("http://customer:8080"))
	            
	            .build();
	    }

}
