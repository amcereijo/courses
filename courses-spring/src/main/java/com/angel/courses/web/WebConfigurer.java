package com.angel.courses.web;

import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
//@EnableSpringDataWebSupport
public class WebConfigurer implements ServletContextInitializer {

    private final Logger log = LoggerFactory.getLogger(WebConfigurer.class);

    @Autowired
    private Environment env;


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
    	log.info("Web application configuration, using profiles: {}", Arrays.toString(env.getActiveProfiles()));

        
        //initGzipFilter(servletContext, disps);
        
        log.info("Web application fully configured");
    }
    
       /**
     * Initializes the GZip filter.
     *
    private void initGzipFilter(ServletContext servletContext, EnumSet<DispatcherType> disps) {
        log.debug("Registering GZip Filter");
        FilterRegistration.Dynamic compressingFilter = servletContext.addFilter("gzipFilter", new GZipServletFilter());
        Map<String, String> parameters = new HashMap<>();
        compressingFilter.setInitParameters(parameters);
        compressingFilter.addMappingForUrlPatterns(disps, true, "/api/*");
        compressingFilter.addMappingForUrlPatterns(disps, true, "/metrics/*");
        compressingFilter.setAsyncSupported(true);
    }*/

   
   
}
