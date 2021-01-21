package com.kfabija.meterreadingsmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class MeterReadingsMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeterReadingsMongoApplication.class, args);
	}

}
