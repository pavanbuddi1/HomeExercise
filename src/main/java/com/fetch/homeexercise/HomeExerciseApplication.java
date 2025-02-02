package com.fetch.homeexercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HomeExerciseApplication {
	public static void main(String[] args) {
		SpringApplication.run(HomeExerciseApplication.class, args);
	}
}


