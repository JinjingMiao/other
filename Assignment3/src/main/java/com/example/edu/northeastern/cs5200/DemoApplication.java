package com.example.edu.northeastern.cs5200;

import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.edu.northeastern.cs5200.model.hw_jdbc_last_first;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
        //testDeveloper();
		try {
			new hw_jdbc_last_first().runTest();
		} catch (ParseException e) {
			e.printStackTrace();
		}

}
}
