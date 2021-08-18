package com.developerconnection.dcbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages ="com.developerconnection.dcbackend.domain")
@EnableJpaRepositories(basePackages = "com.developerconnection.dcbackend.repository")
@SpringBootApplication
public class DcBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DcBackendApplication.class, args);
	}

}
