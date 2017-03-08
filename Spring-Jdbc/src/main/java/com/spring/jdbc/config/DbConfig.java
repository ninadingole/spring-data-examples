package com.spring.jdbc.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by ninad on 3/8/2017.
 */
@Configuration
@EnableAutoConfiguration
public class DbConfig {

    @Value("${db.driverClassName}")
    private String driverClassName;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Value("${db.url}")
    private String url;

    @Bean(destroyMethod = "close")
    public DataSource mySqlDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(this.driverClassName);
        dataSource.setUsername(this.username);
        dataSource.setPassword(this.password);
        dataSource.setUrl(url);
        return dataSource;
    }


}
