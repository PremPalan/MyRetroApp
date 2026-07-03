package com.ram.myretro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class MyretroApplication {

	private static final Logger log = LoggerFactory.getLogger(MyretroApplication.class);

	public static void main(String[] args) {
		// SpringApplication.run(MyretroApplication.class, args);

		new SpringApplicationBuilder()
				.sources(MyretroApplication.class)
				.logStartupInfo(false)
				.lazyInitialization(true)
				.bannerMode(Banner.Mode.OFF)
				.web(WebApplicationType.NONE)
				.profiles("cloud")
				.listeners(event -> log.info("Event: {}", event.getClass().getCanonicalName()))
				.run(args);
	}

}
