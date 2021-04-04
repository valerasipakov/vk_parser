package com.javastart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Service
public class GroupService {

    @Value("6ef3638a6ef3638a6ef3638ad46e845a6966ef36ef3638a0e9a9cf68503993762890549")
    private String serviceToken;

    private final RestTemplate restTemplate;

    @Autowired
    public GroupService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> getGroupPosts(String domain){

        //https://api.vk.com/method/wall.get?domain=&access_token=token&v=5.52
        String requestUrl = new String("https://api.vk.com/method/wall.get?domain="
                + domain + "&count=1&access_token=" + serviceToken + "&v=5.52" );

        ResponseEntity<String> response
                = restTemplate.getForEntity(requestUrl, String.class);
        return response;
    }

    public String splitLink(String link){
        String[] splintedLink = link.split("/");
        return  splintedLink[3];
    }
}
