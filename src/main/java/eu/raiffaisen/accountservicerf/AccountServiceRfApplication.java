package eu.raiffaisen.accountservicerf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableCaching
public class AccountServiceRfApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceRfApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceRfApplication.class, args);

        LOGGER.info("### APP STARTED ###");
        System.out.println("### APP STARTED ###");
    }

}
