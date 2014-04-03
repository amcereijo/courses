package com.angel.courses.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@PropertySource(value = "classpath:config/databaseTest.properties")
public class DatabaseTestConfiguration extends DatabaseConfigurationBase{
}
