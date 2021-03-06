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
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.angel.courses.repository.CourseRepository;
import com.angel.courses.repository.LevelRespository;
import com.angel.courses.repository.TeacherRepository;


public abstract class DatabaseConfigurationBase implements EnvironmentAware {
		
		private static final Logger LOG = LoggerFactory.getLogger(DatabaseConfigurationBase.class);
				
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
		
		@Bean
		public MapperFactoryBean<LevelRespository> getLevelRespositoryMapper(SqlSessionFactory sqlSessionFactory){
			MapperFactoryBean<LevelRespository> mapperFactoryBean = new MapperFactoryBean<LevelRespository>();
			mapperFactoryBean.setMapperInterface(LevelRespository.class);
			mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
			LOG.info("LevelRespositoryMapper created....");
			return mapperFactoryBean;
		}
		
		@Bean
		public MapperFactoryBean<TeacherRepository> getTeacherRepositoryMapper(SqlSessionFactory sqlSessionFactory){
			MapperFactoryBean<TeacherRepository> mapperFactoryBean = new MapperFactoryBean<TeacherRepository>();
			mapperFactoryBean.setMapperInterface(TeacherRepository.class);
			mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
			LOG.info("TeacherRepositoryMapper created....");
			return mapperFactoryBean;
		}
	
}
