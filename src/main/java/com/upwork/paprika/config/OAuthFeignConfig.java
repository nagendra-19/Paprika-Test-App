package com.upwork.paprika.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

@Configuration
public class OAuthFeignConfig {

    @Autowired
    RestTemplateTokenRequester restTemplateTokenRequester;


    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Authorization", "Bearer " + restTemplateTokenRequester.requestAccessToken().getAccessToken());
        };
    }
}