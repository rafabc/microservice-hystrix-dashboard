package com.micro.car.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.car.dto.Car;
import com.micro.car.service.CarService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.exception.FallbackDefinitionException;

@RestController
public class CarController {
	
	
//	List<Car> cars;
	
	@Autowired
	private CarService carService;
	
//	public CarController() {
//		
//		 cars = new ArrayList<Car>();
//		 cars.add(new Car("1", "For", "Mondeo", "Gris", "2015", "175"));
//		 cars.add(new Car("2", "Fiat", "Bravo", "Azul", "2001", "105"));
//		 cars.add(new Car("3", "Alfa Romeo", "159", "Negro", "2008", "150"));
//		 cars.add(new Car("4", "Ferrari", "GTO", "Rojo", "1995", "350"));
//		 cars.add(new Car("5", "Mercedes", "350", "Negro", "2005", "220"));
//		 cars.add(new Car("6", "Alfa Romeo", "147", "Negro", "2008", "105"));
//		
//	}

	@HystrixCommand(fallbackMethod = "defaultCarById")
	@RequestMapping("/car/{id}")
	public Car getCar(@PathVariable("id") String id) {
		
		throw new FallbackDefinitionException("");
		
		//return carService.getCarById(id);
		
		//return cars.get(Integer.valueOf(id) - 1);
	}
	
	
	public Car defaultCarById(String id) {
		
		return new Car(id,"def", "def","def", "def", "def");
	}
	
	
	@RequestMapping("/")
	public List<Car> getIndex() {
		
		return carService.getCars();
	}
}
