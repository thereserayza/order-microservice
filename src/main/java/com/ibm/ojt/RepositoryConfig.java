package com.ibm.ojt;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RepositoryConfig {
    
    public CustomConversions customConversions() {
		return new CustomConversions(Arrays.asList(new StringToLocalDateTimeConverter()));
    }
    
    public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("http://kariteun-shopping.mybluemix.net", "http://localhost:3000");
	}
}