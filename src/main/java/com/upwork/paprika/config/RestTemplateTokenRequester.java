package com.upwork.paprika.config;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateTokenRequester {

    public TokenResponse requestAccessToken() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id", "az3aiekxthch8y1yp5ypdhg9gyusu3lr");
        map.add("client_secret", "3ae8ooz1vgg299vg3tgy5mretpli477");
        map.add("grant_type", "client_credentials");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

        ResponseEntity<TokenResponse> response =
                restTemplate.exchange("https://i2-testing.paprika-software.com/exam/auth/token",
                        HttpMethod.POST,
                        entity,
                        TokenResponse.class);
        return response.getBody();
    }
}