package com.dxc.appl.demo.springbootadminserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import de.codecentric.boot.admin.server.config.AdminServerProperties;

/**
 * see: http://codecentric.github.io/spring-boot-admin/2.0.0/#_securing_spring_boot_admin_server
 *      https://github.com/codecentric/spring-boot-admin/blob/master/spring-boot-admin-samples/spring-boot-admin-sample-servlet/src/main/java/de/codecentric/boot/admin/SpringBootAdminApplication.java
 *      
 * @author rferstl
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final String adminContextPath;

    public SecurityConfig(AdminServerProperties adminServerProperties) {
        this.adminContextPath = adminServerProperties.getContextPath();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");

        // add basicAuth for REST client
        http
        	.cors()
        .and()
        	.authorizeRequests()
            	.antMatchers(adminContextPath + "/assets/**").permitAll()
            	.antMatchers(adminContextPath + "/login").permitAll()
            	// TODO DXCRFE the actuator should be protected but isn't
            	.antMatchers(adminContextPath + "/actuator/**").permitAll()
            	.anyRequest().authenticated()
        .and()
        	.formLogin()
        		.loginPage(adminContextPath + "/login").successHandler(successHandler)
        .and()
        	.logout().logoutUrl(adminContextPath + "/logout")
        .and()
        	.httpBasic()
        .and()
        	.csrf().disable();
        super.configure(http);
    }
}