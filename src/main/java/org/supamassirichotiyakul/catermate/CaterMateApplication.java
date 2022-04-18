package org.supamassirichotiyakul.catermate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.supamassirichotiyakul.catermate.security.SecurityConfiguration;

@SpringBootApplication		// Use this one for real application with Spring security
//@SpringBootApplication(exclude = SecurityConfiguration.class)	// Use this one for testing RestController
public class CaterMateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaterMateApplication.class, args);
	}

}
