package com.dxc.appl.demo.springbootadminserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.server.config.EnableAdminServer;


@Configuration
@EnableAutoConfiguration
@EnableAdminServer
public class SpringBootAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAdminServerApplication.class, args);
	}
	
//	private final String adminContextPath="";
	
//	@Bean
//	public SecurityWebFilterChain securityWebFilterChainSecure(ServerHttpSecurity http) {
//		// @formatter:off
//		return http.authorizeExchange().pathMatchers(adminContextPath + "/assets/**").permitAll()
//				.pathMatchers(adminContextPath + "/login").permitAll().anyExchange().authenticated().and().formLogin()
//				.loginPage(adminContextPath + "/login").and().logout().logoutUrl(adminContextPath + "/logout").and()
//				.httpBasic().and().csrf().disable().build();
//		// @formatter:on
//	}
	
}
