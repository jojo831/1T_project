//package com.fndroid.filter;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//public class WebMvcAdapter  extends WebMvcConfigurerAdapter{
//
//	   @Override
//	    public void addInterceptors(InterceptorRegistry registry) {
//	        registry.addInterceptor(new WebInterceptor()).addPathPatterns("/**");  //对来自/api/** 这个链接来的请求进行拦截
//	    }
//}
