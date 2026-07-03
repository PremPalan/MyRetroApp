package com.ram.myretro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({MyRetroProperties.class})
public class MyRetroConfiguration {

    private static final Logger log = LoggerFactory.getLogger(MyRetroConfiguration.class);

//    @Value("${users.server}")
//    String server;

//    @Bean
//    CommandLineRunner commandLineRunner() {
//        return args -> log.info("[CLR] Args: {}", Arrays.toString(args));
//    }
//
//    @Bean
//    ApplicationRunner applicationRunner() {
//        return args -> {
//            log.info("[AR] Option Args: {}", args.getOptionNames());
//            log.info("[AR] Option Arg Values: {}", args.getOptionValues("option"));
//            log.info("[AR] Non Option: {}", args.getNonOptionArgs());
//        };
//    }
//
//    @Bean
//    ApplicationListener<ApplicationReadyEvent> applicationReadyEventListener() {
//        return event -> log.info("[AL] I'm ready to interact...");
//    }

//    @Value("${users.port}")
//    Integer port;
//    @Value("${users.username}")
//    String username;
//    @Value("${users.password}")
//    String password;

    public MyRetroConfiguration(ApplicationArguments arguments) {
//        // Output: [enable, remote, option]
//        log.info("Option Args: {}", arguments.getOptionNames());
//
//        // Output: [value1, value2]
//        log.info("Option Arg Values: {}", arguments.getOptionValues("option"));
//
//        // Output: [update, upgrade]
//        log.info("Option: {}", arguments.getNonOptionArgs());
    }

//    @Bean
//    ApplicationListener<ApplicationReadyEvent> init() {
//        return event -> {
//            log.info("\nThe users service properties are:\n- Server: {}\n- Port:{}\n - Username:{}\n - Password:{} ", server, port, username, password);
//        };
//    }

    @Bean
    ApplicationListener<ApplicationReadyEvent> init(MyRetroProperties
                                                            myRetroProperties) {
        return event -> {
            log.info("\nThe users service properties are:\n- Server: {}\n- Port: {}\n- Username: {}\n- Password: {}",
                    myRetroProperties.getUsers().getServer(),
                    myRetroProperties.getUsers().getPort(),
                    myRetroProperties.getUsers().getUsername(),
                    myRetroProperties.getUsers().getPassword());
        };
    }
}