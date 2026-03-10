package com.sleeperapi.sleeperapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SleeperapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SleeperapiApplication.class, args);
	}

}
