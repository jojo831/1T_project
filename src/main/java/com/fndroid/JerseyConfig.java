package com.fndroid;

import javax.annotation.PostConstruct;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fndroid.controller.JerseyDemo;
import com.fndroid.controller.JerseyTest;
import com.fndroid.controller.TestController;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@Component
public class JerseyConfig extends ResourceConfig {

	
	   @Value("${spring.jersey.application-path}")
	    private String apiPath;
	   
	   @Value("${server.servlet-path}")
	    private String path;
	   

	  public JerseyConfig() {
	        //构造函数，在这里注册需要使用的内容，（过滤器，拦截器，API等）
		  
		  register(JerseyDemo.class);
		  register(JerseyTest.class);
		  register(TestController.class);
		  
//		  packages("com.fndroid");
		  
	    }
	  
	  @PostConstruct
	    public void init() {
	        // Register components where DI is needed
	        this.configureSwagger();
	    }
	  


	    private void configureSwagger() {
	        // Available at localhost:port/swagger.json
	        this.register(ApiListingResource.class);
	        this.register(SwaggerSerializers.class);
	        BeanConfig config = new BeanConfig();
	        config.setConfigId("springboot-jersey-swagger-docker-example");
	        config.setTitle("Spring Boot + Jersey + Swagger + Docker Example");
	        config.setVersion("v1");
	        config.setContact("wzh");
	        config.setSchemes(new String[] { "http", "https" });
	        config.setBasePath(this.apiPath);
	        config.setResourcePackage("com.fndroid");
	        config.setPrettyPrint(true);
	        config.setScan(true);
	    }
}
