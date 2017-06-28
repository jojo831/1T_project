//package com.fndroid.filter;
//
//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.fndroid.controller.JerseyDemo;
//import com.fndroid.dao.UserDao;
//import com.fndroid.entity.Relation;
//
//import java.util.List;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Component
//public class WebInterceptor  implements HandlerInterceptor {
//
//	@Resource
//	UserDao userDao;
//	
//	@Resource
//	JerseyDemo jerseyDemo;
//	
//	 @Override
//	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//	            throws Exception {
//	        System.out.println(">>>MyInterceptor1>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
////	        String contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +
////	        request.getContextPath()+request.getQueryString();
//
////	        String contextpath = "";
////	       
////	        contextpath = request.getScheme() +"://" + request.getServerName()  
////	        
////	                                + ":" +request.getServerPort() 
////	        
////	                                + request.getServletPath();
////	        
////	                if (request.getQueryString() != null){
////	        
////	                	contextpath += "?" + request.getQueryString();
////	        
////	                }
////	        
////		System.out.println("request.getServerName() " + request.getServerName());
////		System.out.println("request.getServerPort() " + request.getServerPort());
////
////		System.out.println("request.getServletPath() " + request.getServletPath());
////		System.out.println("request.getRequestURI() " + 	request.getRequestURI());
////		System.out.println("response.getStatus() " + 	response.getStatus());
////
////
////	        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext()); 
////	        userDao = (UserDao) factory.getBean("userDao");
////	        Relation relation = userDao.findUserSql(contextpath);
////	        if(relation!=null)
////	        {
////	            System.out.println("### sql = " + relation.getSql());
//////	            List<Object> object = userDao.getInfo(relation.getSql());
//////	            jerseyDemo = (JerseyDemo) factory.getBean("jerseyDemo");
//////	            jerseyDemo.getResultInfo(object);
////	            
////	            response.sendRedirect("http://localhost:8080/apiTest/check/"+relation.getSql());
////	            return false;
////	            
////	        }
////	        else
////	        {
////	        	
////	        }
//	  
//	        return true;// 只有返回true才会继续向下执行，返回false取消当前请求
//	    }
//
//	    @Override
//	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//	            ModelAndView modelAndView) throws Exception {
////	        System.out.println(">>>MyInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
//	    }
//
//	    @Override
//	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//	            throws Exception {
////	        System.out.println(">>>MyInterceptor1>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
//	    }
//	
////	  private static final Logger logger = LoggerFactory.getLogger(UserInterceptor.class);
////	    @Override
////	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
////	        /**
////	         * 对来自后台的请求统一进行日志处理
////	         */
////	        String url = request.getRequestURL().toString();
////	        String method = request.getMethod();
////	        String uri = request.getRequestURI();
////	        String queryString = request.getQueryString();
////	        System.out.println(request.getParameterMap());
////	        logger.info(String.format("请求参数, url: %s, method: %s, uri: %s, params: %s", url, method, uri, queryString));
////	        return true;
////	    }
////
////	    @Override
////	    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
////
////	    }
////
////	    @Override
////	    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
////
////	    }
//}
