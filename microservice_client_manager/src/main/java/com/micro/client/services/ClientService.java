package com.micro.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.micro.client.dto.Car;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
public class ClientService {

    @Autowired
    private RestTemplate template;
    
    
    private final static String SERVICE_CAR_URL = "http://servicio-car/car/{id}";
	
    @HystrixCommand(fallbackMethod = "defaultCar")
	public Car getCar(String id) {
		
    	ResponseEntity<Car> response = null;
    	
		for (int i=0; i<100; i++){
			response = template.exchange(SERVICE_CAR_URL, HttpMethod.GET, null, new ParameterizedTypeReference<Car>() {}, id);
		}

		return response.getBody();
		
	}
    
    public Car defaultCar(String e) {
        return new Car("default car","2","3","4");
    	
      }
	
	
	
}
