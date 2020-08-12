package com.ranga.demo.orderservice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@EnableFeignClients(basePackages = "com.ranga.demo.orderservice.integration")
@ComponentScan(basePackages = {"com.ranga.demo.orderservice.app", "com.ranga.demo.orderservice.app.rest"})
@SpringBootApplication
@EnableDiscoveryClient
public class App extends SpringBootServletInitializer {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(App.class, args);
	}
}
