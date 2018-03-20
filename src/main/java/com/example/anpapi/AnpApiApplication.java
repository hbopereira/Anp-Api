package com.example.anpapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.anpapi.config.property.AnpApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(AnpApiProperty.class)
public class AnpApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnpApiApplication.class, args);
	}
}
