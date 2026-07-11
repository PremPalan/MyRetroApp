package com.ram.myretro.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "service")
@Data
public class MyRetroProperties {
    private UsersProperties users = new UsersProperties();
}