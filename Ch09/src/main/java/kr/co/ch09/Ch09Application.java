package kr.co.ch09;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan
@SpringBootApplication
public class Ch09Application {

	public static void main(String[] args) {
		SpringApplication.run(Ch09Application.class, args);
	}

}
