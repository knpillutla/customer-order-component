package com.example.order;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.example.order.streams.CustomerOrderStreams;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableBinding(CustomerOrderStreams.class)
@EnableAutoConfiguration
@EnableScheduling
@Slf4j
public class CustomerOrderApplication {
	private Random random = new Random();
	public static void main(String[] args) {
		SpringApplication.run(CustomerOrderApplication.class, args);
	}
}
