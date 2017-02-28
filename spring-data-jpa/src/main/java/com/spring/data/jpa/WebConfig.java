package com.spring.data.jpa;

import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Web Configuration to support Spring-Data-Web support.
 * Created by ninad on 2/26/2017.
 */
@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
public class WebConfig {

    @Bean
    public EmbeddedServletContainerFactory embeddedServletContainer(){
        return new JettyEmbeddedServletContainerFactory(8080);
    }

}
