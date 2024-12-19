package com.login.password.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class GraphQLClientCOnfig {
	
	
	@Bean
	public HttpGraphQlClient getGraphQlClient() {
		WebClient webClient = WebClient.builder().baseUrl("http://localhost:8081/user/graphql").build();
		return HttpGraphQlClient.builder(webClient).build();
	}

}
