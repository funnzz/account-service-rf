package eu.raiffaisen.accountservicerf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountServiceRfApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceRfApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceRfApplication.class, args);

		LOGGER.info("### APP STARTED ###");
		System.out.println("### APP STARTED ###");
	}

}
