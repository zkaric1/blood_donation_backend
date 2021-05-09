package ba.red_cross.blood_donation;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BloodDonationApplication {

    private static final Logger log =
            LoggerFactory.getLogger(BloodDonationApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BloodDonationApplication.class, args);
    }


    @Bean
    public CommandLineRunner addDataToDatabase() {
        return (args) -> {
            log.info("ok");
        };

    }
}
