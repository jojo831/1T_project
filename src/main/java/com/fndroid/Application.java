package com.fndroid;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import com.alibaba.druid.pool.DruidDataSource;
import com.fndroid.service.BookService;

import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;



@EnableAutoConfiguration
@ComponentScan
@ServletComponentScan   //扫描Servlet
@MapperScan("com.fndroid.dao")
@SpringBootApplication
public class Application {

    @Resource
    DruidDataSourceConfiguration dataSourceConfiguration;
    
	 private static Logger logger = Logger.getLogger(Application.class);
//	 @Bean
//	    @ConfigurationProperties(prefix="spring.datasource")
//	    public DataSource dataSource() {
//	        return new org.apache.tomcat.jdbc.pool.DataSource();
//	    }
	 
		
	  //提供SqlSeesion
	    @Bean
	    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
	 
	        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
	        sqlSessionFactoryBean.setDataSource(dataSourceConfiguration.getDataSource());
	 
	        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
	 
	        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
	 
	        return sqlSessionFactoryBean.getObject();
	    }
	    
	    @Bean
	    public PlatformTransactionManager transactionManager() {
	        return new DataSourceTransactionManager(dataSourceConfiguration.getDataSource());
	    }
	    

//	    @Bean
//	    public ServletRegistrationBean jerseyServlet() {
//	        ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/*");
//	        registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
//	        return registration;
//	    }
	    
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        logger.info("============= SpringBoot Start Success =============");
    }

  
}