package com.cgi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JpaConfig.class, WebMvcConfig.class})
public class ConfigContext {

}
