   package com.harman.controller;

import java.util.Arrays;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.messaging.eventhubs.EventData;
import com.azure.messaging.eventhubs.EventDataBatch;
import com.azure.messaging.eventhubs.EventHubClientBuilder;
import com.azure.messaging.eventhubs.EventHubProducerClient;
import com.harman.dto.CellularInfo;
import com.microsoft.azure.eventhubs.EventHubClient;
import com.microsoft.azure.eventhubs.impl.EventHubClientImpl;
import com.harman.dto.ObjectToJson;

@RestController
public class AzureAppTestController {
	

	private static final String connectionString = "Endpoint=sb://aanamespace.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=sjjnI8IM10yujqiIlwp+2YFRpZvVkUfBgPGZX3t9BzA=";		
	private static final String eventHubName = "aaeventhub";

	//private static final String connectionString = "Endpoint=sb://bbnamespace.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=4Bd70m4anqOvTwh7J1w2juT73RRGGbbOp2cMHneBIhU=";		
	//private static final String eventHubName = "bbeventhub";
	@GetMapping(value ="/message")
	public String getStarupMessage() {
		return "This is a Demo webapp deployed Successfully";
		
	}
		
	public static String getConnectionString () {	
			return connectionString;
	}
			
	
	public static String getEventhubname() {
			return eventHubName;
	
	}
			
		
		
		/**
	     * Code sample for publishing events.
	     * @throws IllegalArgumentException if the EventData is bigger than the max batch size.
	     */
	    public static void publishEvents() {
	        // create a producer client
	        EventHubProducerClient producer = new EventHubClientBuilder()
	            .connectionString(connectionString, eventHubName)
	            .buildProducerClient();

	        // sample events in an array
	        
	        // 
	        List<EventData> allEvents = Arrays.asList(new EventData("test"), new EventData("message"));

	        // create a batch
	        EventDataBatch eventDataBatch = producer.createBatch();

	        for (EventData eventData : allEvents) {
	            // try to add the event from the array to the batch
	            if (!eventDataBatch.tryAdd(eventData)) {
	                // if the batch is full, send it and then create a new batch
	                producer.send(eventDataBatch);
	                eventDataBatch = producer.createBatch();

	                // Try to add that event that couldn't fit before.
	                if (!eventDataBatch.tryAdd(eventData)) {
	                    throw new IllegalArgumentException("Event is too large for an empty batch. Max size: "
	                        + eventDataBatch.getMaxSizeInBytes());
	                }
	            }
	        }
	        // send the last batch of remaining events
	        if (eventDataBatch.getCount() > 0) {
	            producer.send(eventDataBatch);
	        }
	        producer.close();
	    }
	    
	    
	    
	    
	    
	    /**
	     * Code sample for publishing events.
	     * @throws IllegalArgumentException if the EventData is bigger than the max batch size.
	     */
	    public static void publishEventsNew(CellularInfo cellInfo) {
	        // create a producer client
	        EventHubProducerClient producer = new EventHubClientBuilder()
	            .connectionString(connectionString, eventHubName)
	            .buildProducerClient();

	        // sample events in an array
	        // 
	        List<EventData> allEvents = Arrays.asList(new EventData(ObjectToJson.convertToJson()));

	        // create a batch
	        EventDataBatch eventDataBatch = producer.createBatch();

	        for (EventData eventData : allEvents) {
	            // try to add the event from the array to the batch
	            if (!eventDataBatch.tryAdd(eventData)) {
	                // if the batch is full, send it and then create a new batch
	                producer.send(eventDataBatch);
	                eventDataBatch = producer.createBatch();

	                // Try to add that event that couldn't fit before.
	                if (!eventDataBatch.tryAdd(eventData)) {
	                    throw new IllegalArgumentException("Event is too large for an empty batch. Max size: "
	                        + eventDataBatch.getMaxSizeInBytes());
	                }
	            }
	        }
	        // send the last batch of remaining events
	        if (eventDataBatch.getCount() > 0) {
	            producer.send(eventDataBatch);
	        }
	        producer.close();
	    }
		
		
	}
	
	
	
	
	

