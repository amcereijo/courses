package com.angel.courses.config.web;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.angel.courses.config.filter.CrossOriginFilter;

@Configuration
public class WebConfigurer implements ServletContextInitializer {

    private final Logger log = LoggerFactory.getLogger(WebConfigurer.class);

    @Autowired
    private Environment env;


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
    	log.info("Web application configuration, using profiles: {}", Arrays.toString(env.getActiveProfiles()));
    	EnumSet<DispatcherType> disps = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ASYNC);
        
        initCrossoriginFilter(servletContext, disps);
        
        log.info("Web application fully configured");
    }
   
    /**
     * Initializes the cross-size filter
     */
    private void initCrossoriginFilter(ServletContext servletContext, EnumSet<DispatcherType> disps) {
        log.debug("Registering GZip Filter");
        FilterRegistration.Dynamic compressingFilter = servletContext.addFilter("gzipFilter", new CrossOriginFilter());
        Map<String, String> parameters = new HashMap<>();
        compressingFilter.setInitParameters(parameters);
        compressingFilter.addMappingForUrlPatterns(disps, true, "/api/*");;
        compressingFilter.setAsyncSupported(true);
    }

   
   
}
