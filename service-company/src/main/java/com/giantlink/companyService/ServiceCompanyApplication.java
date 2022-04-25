package com.giantlink.companyService;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.giantlink.companyService.entities.Company;
import com.giantlink.companyService.repositories.CompanyRepository;

@EnableEurekaClient
@SpringBootApplication
public class ServiceCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCompanyApplication.class, args);
		System.out.println("executed well");
	}
	
	@Bean
	CommandLineRunner commandLineRunner(CompanyRepository companyRepository) {
		return args->{
			Stream.of("a","b","c").forEach(cs-> companyRepository.save(new Company(null, cs, 100+Math.random()*900)));
			/*companyRepository.findAll().forEach(s->{
				System.out.println(s.toString());
			});*/
			
			companyRepository.findAll().forEach(System.out::println);
		};
	}

}
