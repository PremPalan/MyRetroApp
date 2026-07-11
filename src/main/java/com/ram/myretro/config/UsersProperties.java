package com.ram.myretro.config;

import lombok.Data;

@Data
public class UsersProperties {
    private String server;
    private Integer port;
    private String username;
    private String password;
}