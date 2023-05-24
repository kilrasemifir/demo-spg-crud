package fr.kira.formation.spring.democrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;


@SpringBootApplication
public class DemoCrudApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoCrudApplication.class, args);
		System.out.println(context.getBean("enDev"));
	}

	@Bean
	@Profile("dev")
	public String enDev(){
		return "Profile Dev actif";
	}

}
