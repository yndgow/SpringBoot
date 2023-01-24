package kr.co.iBoard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan
@SpringBootApplication
public class IBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(IBoardApplication.class, args);
	}

}
