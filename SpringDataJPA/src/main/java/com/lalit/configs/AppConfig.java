package com.lalit.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import(PersistenceConfig.class)
@ComponentScan(basePackages = "com.lalit")
public class AppConfig {
}
