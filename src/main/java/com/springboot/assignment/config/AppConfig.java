package com.springboot.assignment.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
public class AppConfig {
	
	@Bean
	public ObjectMapper configObjectMapper() {
		ObjectMapper objMapper = new ObjectMapper();
		objMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		objMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objMapper.setSerializationInclusion(Include.NON_NULL);
		return objMapper;
		
	}

	@Bean
	public RestTemplate getRestTemplate() {
		System.out.println("asdf");
		return new RestTemplate();
	}
	
	@Bean
	public HttpEntity<String> getHttpJSONEntity(){
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	    return entity;
	}
}
