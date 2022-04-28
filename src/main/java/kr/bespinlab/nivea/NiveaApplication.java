package kr.bespinlab.nivea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NiveaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NiveaApplication.class, args);
	}

}
