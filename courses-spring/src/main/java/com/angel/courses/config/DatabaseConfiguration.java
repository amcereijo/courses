package com.angel.courses.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:config/database.properties")
public class DatabaseConfiguration extends DatabaseConfigurationBase{
}
