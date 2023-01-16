package kr.co.ch09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Ch09Application {

	public static void main(String[] args) {
		SpringApplication.run(Ch09Application.class, args);
	}

}
