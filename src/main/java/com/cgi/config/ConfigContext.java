package com.cgi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"com.cgi.dao", "com.cgi.controller", "com.cgi.controller.rest" })
@Import({JpaConfig.class, WebMvcConfig.class})
public class ConfigContext {

}
