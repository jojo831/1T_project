package com.fndroid.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.StreamingOutput;

import org.springframework.stereotype.Component;


/**
 * 
 */
@Component
@Path("/hello")
public class JerseyTest{
	
		@GET  
	    @Produces("text/plain")  
	    public String helloWorld(){  
	        return "hello world";  
	    }  
	    /* 
	     * post param  test 
	     */  
	    @POST     
	    @Path("echo")  
	    @Consumes("application/x-www-form-urlencoded")    
	    public String echo(@FormParam("msg") String msg){  
	        return "are you say "+msg;  
	    }  
	    /* 
	     * get param test 
	     */  
	    @GET  
	    @Path("sex")  
	    @Produces("text/plain")  
	    public String getSex(@PathParam("name") String name){  
	        return "male";  
	    }  
	      
	    /* 
	     * get {} request  
	     * http://houfeng:8080/jerseyWebServiceTest/services/hello/age/houfeng 
	     */  
	    @GET  
	    @Path("age/{name}")  
	    @Produces("text/plain")  
	    public String getAge(@PathParam("name") String name){  
	        return "18";  
	    }  
	      
	      
	    /* 
	     * get {} request 
	     * http://houfeng:8080/jerseyWebServiceTest/services/hello/223232323 
	     */  
	    @GET  
	    @Path ("{id}")  
	    @Produces ("application/xml")  
	    public StreamingOutput retrieveCustomer(@PathParam ("id") String customerId) {  
	        String customerDetails = "hou,feng,232";   
	        final String[] details = customerDetails.split(",");   
	        return new StreamingOutput() {    
	            public void write(OutputStream outputStream) {    
	                PrintWriter out = new PrintWriter(outputStream);  
//	                out.println("<?xml version=/"1.0/" encoding=/"UTF-8/"?>");  
	                out.println("<customer>");  
	                out.println("<firstname>" + details[0] + "</firstname>");  
	                out.println("<lastname>" + details[1] + "</lastname>");  
	                out.println("<zipcode>" + details[2] + "</zipcode>");  
	                out.println("</customer>");  
	                out.close();  
	            }   
	        };   
	    }  
	      
	      
	    // get  vs  post   
	      
	    @GET  
	    @Path("test_get")  
	    @Produces("text/plain")  
	    public String getTest1(HttpServletRequest request){  

	    	HttpServletRequest httpRequest=(HttpServletRequest)request;  
	          
	    	String strBackUrl = "http://" + request.getServerName() //服务器地址  
	    	                    + ":"   
	    	                    + request.getServerPort()           //端口号  
	    	                    + httpRequest.getContextPath()      //项目名称  
	    	                    + httpRequest.getServletPath()      //请求页面或其他地址  
	    	                + "?" + (httpRequest.getQueryString()); //参数   
	        return strBackUrl;  
	    }  
	      
	    /* 
	     * get 方式 正确的获取参数方法 @QueryParam 或者 用 request； url里有参数的用PathParam 
	     */  
	    @GET  
	    @Path("test_get2")  
	    @Produces("text/plain")  
	    public String getTest11(@QueryParam("name") String name, @Context HttpServletRequest request){  
	        System.out.println("name:"+name);// houfeng  
	        String result;  
	        result = request.getParameter("name");  
	        System.out.println("name="+result); //houfeng    
	        result+= "--------"+request.getContextPath();   
	        return result;  
	    }  
	   
	      
	    @POST  
	    @Path("test_post1")  
	    @Consumes("application/x-www-form-urlencoded")   
	    @Produces("text/plain")  
	    public String getTest2(@FormParam("name") String name){   
	        System.out.println(name);//houfeng  
	        String result=name;    
	        return result;  
	    }  
	      
	    @POST  
	    @Path("test_post2")  
	    @Consumes("application/x-www-form-urlencoded")   
	    @Produces("text/plain")  
	    public String getTest22(@QueryParam("name") String name){  
	        System.out.println("name:"+name);//houfeng,但是有警告。提示用FormParam  
	        String result = name;   
	        return result;  
	    }  
	      
	      
	    @POST  
	    @Path("test_post3")   
	    @Produces("text/plain")  
	    public String getTest2222(String entity, @Context HttpServletRequest request){  
	        System.out.println("entity:"+entity);//hello 传入方式：resource.entity("hello").post(String.class);  
	        String result;   
	        result= "--------"+request.getContextPath();   
	        return result;  
	    }  
	      
	    @POST  
	    @Path("test_post4")  
	    //@Consumes("application/xml"),这样就会出错；@Consumes("application/x-www-form-urlencoded") 可以。  
	    @Produces("text/plain")  
	    public String getTest22222(InputStream is, @Context HttpServletRequest request) throws Exception{  
	        byte[] buf = new byte[is.available()];  
	        is.read(buf);  
	        System.out.println("buf:"+new String(buf));  
	        String result;   
	        result= "--------"+request.getContextPath();   
	        return result;  
	    }
	 
      
}