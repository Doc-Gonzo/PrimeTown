package at.mathias_schaller.PrimeTown;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class PrimeTownApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeTownApplication.class, args);
	}

}
