package com.harman;
import com.azure.messaging.eventhubs.*;

import com.harman.dto.CellularInfo;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import static com.harman.controller.AzureAppTestController.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.harman.dto.*;

@SpringBootApplication

public class AzureAppTestApplication {
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(AzureAppTestApplication.class, args);
		
		publishEvents();
	}

	
	
}

