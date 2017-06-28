package com.fndroid.controller;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.fndroid.dao.UserDao;
import com.fndroid.entity.City;
import com.fndroid.entity.Relation;
import com.fndroid.service.BookService;


/**
 * 
 */
@Component
@Path("/demo")
public class JerseyDemo {
	
	@Resource
	UserDao userDao;
	
	@Inject
	BookService service;
	
    //path注解指定路径,get注解指定访问方式,produces注解指定了返回值类型，这里返回JSON
    @Path("/get_info")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Relation get(){
    	
//    	  String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
//          
//    	  System.out.println("### contextpath = " + contextpath);
    	  return service.getRelation();
    }
	 
    @Path("/city/{code}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //    @Produces("text/plain;charset=UTF-8")
    public City getCity(@PathParam("code") String code,@Context HttpServletRequest request){
    	

    	  return service.getCityInfo(code);
    }
    

}