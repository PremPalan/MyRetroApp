package com.ram.myretro.client;

import com.ram.myretro.config.MyRetroProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

@RequiredArgsConstructor
@Component
public class UsersClient {

    private static final String USERS_URL = "/users";
    private final RestTemplate restTemplate = new RestTemplate();
    private final MyRetroProperties myRetroProperties;

    public User findUserByEmail(String email) {
        String uri = MessageFormat.format(
                "{0}:{1}{2}/{3}",
                myRetroProperties.getUsers().getServer(),
                myRetroProperties.getUsers().getPort().toString(),
                USERS_URL,
                email
        );

        return restTemplate.getForObject(uri, User.class);
    }
}