package com.harman;
import static com.harman.controller.EventHubController.*;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventHubIngestionJsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventHubIngestionJsonApplication.class, args);
		publishEventsNew();
	}

}
