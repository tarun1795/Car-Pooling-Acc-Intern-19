package com.accolite.carpooling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.accolite.carpooling.config.AppConfig;
import com.accolite.carpooling.dao.impl.VehicleDAOImpl;
import com.accolite.carpooling.dao.interfaces.VehicleDAO;

@SpringBootApplication
public class CarPoolingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarPoolingApplication.class, args);
	}

}

