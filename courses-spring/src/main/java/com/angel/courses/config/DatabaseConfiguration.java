package com.angel.courses.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.angel.courses.repository.CourseRepository;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:config/database.properties")
public class DatabaseConfiguration implements EnvironmentAware {
	
	private static final Logger LOG = LoggerFactory.getLogger(DatabaseConfiguration.class);
			
	@Autowired
	private Environment env;
	
	private RelaxedPropertyResolver propertyResolver;
	
	@Override
	public void setEnvironment(Environment environment) {
		this.propertyResolver = new RelaxedPropertyResolver(environment, "");
	}
	
	@Bean
    public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(propertyResolver.getRequiredProperty("dataSource.driverClassName"));
        dataSource.setUrl(propertyResolver.getRequiredProperty("dataSource.url"));
        dataSource.setUsername(propertyResolver.getRequiredProperty("dataSource.username"));
        dataSource.setPassword(propertyResolver.getRequiredProperty("dataSource.password"));
        
        LOG.info("DataSource loaded....");
        return dataSource;
    }

	@Bean
	public SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource dataSource){
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setTypeAliasesPackage("com.angel.courses.domain");
		sessionFactoryBean.setMapperLocations(new Resource[] { 
				new ClassPathResource("ibatis/mappings/coursesMapper.xml") 
		});
		
		LOG.info("SqlSessionFacory created....");
		return sessionFactoryBean;
	}
	
	@Bean
	public MapperFactoryBean<CourseRepository> getCourseRepositoryMapper(SqlSessionFactory sqlSessionFactory){
		MapperFactoryBean<CourseRepository> mapperFactoryBean = new MapperFactoryBean<CourseRepository>();
		mapperFactoryBean.setMapperInterface(CourseRepository.class);
		mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
		LOG.info("CourseRepositoryMapper created....");
		return mapperFactoryBean;
	}
	
}
