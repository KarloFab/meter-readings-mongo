package com.kfabija.meterreadingsmongo.config;

import com.github.cloudyrock.mongock.driver.mongodb.springdata.v3.SpringDataMongo3Driver;
import com.github.cloudyrock.spring.v5.MongockSpring5;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class DatabaseConfiguration {

    @Bean
    public MongockSpring5.MongockInitializingBeanRunner mongockInitializingBeanRunner(
            ApplicationContext springContext,
            MongoTemplate mongoTemplate){

        return MongockSpring5.builder()
                .setDriver(SpringDataMongo3Driver.withDefaultLock(mongoTemplate))
                .addChangeLogsScanPackage("com.kfabija.meterreadingsmongo.config.dbmigrations")
                .setSpringContext(springContext)
                .buildInitializingBeanRunner();
    }
}
