package com.giantlink.gateWayService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


@EnableEurekaClient
@SpringBootApplication
public class ServiceGatewayApplication {
	
	
	//this bean to configure our load balancing in a static way
	//it's a useles way coz we should know all nams of our services in our eureka broker
	//where we can forturnatly manage that automaticaly by the next bean named "dynamicBean"
	//also we don't nead the yml file but it can stay there for u to see the static configuration 
	//if we don't want even to use the bean for the static method, but the yml file should be named application.yml
	//we can also mixt the both methods(static and dynamic)
	/**
	 * @Bean
	 * @param routeBuilder
	 * @return
	 * 
	 *         RouteLocator routeLocator(RouteLocatorBuilder routeBuilder) {
	 *         System.out.println("replace yml file"); return routeBuilder.routes().
	 *         //lb => load balancing
	 *         route(r->r.path("/companies/**").uri("lb://COMPANY-SERVICE")).build();
	 *         }
	 */
	
	@Bean
	DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp) {
		return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
	}
	

	public static void main(String[] args) {
		SpringApplication.run(ServiceGatewayApplication.class, args);
		System.out.println("gatway service");
	}

}
