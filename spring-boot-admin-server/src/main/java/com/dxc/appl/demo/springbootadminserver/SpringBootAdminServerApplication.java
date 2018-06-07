package com.dxc.appl.demo.springbootadminserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@Configuration
@Import({ SecurityConfig.class })
@EnableAutoConfiguration
@EnableAdminServer
public class SpringBootAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAdminServerApplication.class, args);
	}
}
