package ch.parrino.financemate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("ch.parrino.financemate")
public class FinancemateApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancemateApplication.class, args);
	}

}
