package com.iter.podelki.zuul.service;

import com.netflix.discovery.EurekaClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServiceMain {

	@Autowired
	@Lazy
	private EurekaClient eurekaClient;

	@Value("${spring.application.name}")
	private String appName;

	public static void main(String[] args) {
		SpringApplication.run(ServiceMain.class, args);
	}

	@RequestMapping("/{path}")
	public String greeting(@PathVariable String path) throws UnknownHostException {
		return String.format("Hello %s! Hostname %s",
							 path,
							 InetAddress.getLocalHost().getHostName());
	}
}
