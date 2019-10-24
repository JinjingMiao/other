package com.example.Assignment3;



import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.edu.northeastern.cs5200.model.hw_jdbc_last_first;

@SpringBootApplication
public class DemoApplicationTests {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplicationTests.class, args);
        //testDeveloper();
		try {
			new hw_jdbc_last_first().runTest();
		} catch (ParseException e) {
			e.printStackTrace();
		}

}
}

