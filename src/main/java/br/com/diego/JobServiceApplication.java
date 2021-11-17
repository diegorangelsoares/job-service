package br.com.diego;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobServiceApplication.class, args);
		System.out.println("Link do swagger: http://localhost:8806/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/");
	}

}
