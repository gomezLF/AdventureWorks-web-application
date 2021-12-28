package co.edu.icesi.adventureWorks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.icesi.adventureWorks"})
public class AdventureWorksApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdventureWorksApplication.class, args);
	}

}
