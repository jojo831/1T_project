package com.fndroid.controller;


import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fndroid.dao.UserDao;
import com.fndroid.entity.Book;
import com.fndroid.entity.Relation;
import com.fndroid.service.BookService;


@RestController
@RequestMapping("/apiTest")
class BookController {

    @Resource
    BookService service;

	@Resource
	UserDao userDao;
	
    @RequestMapping("/books")
    List<Book> getBooks() {
    	return service.getBooks();
    
    } 
    
    @RequestMapping(value="/books/{id}",produces="application/json;charset=UTF-8")
    Book getBook(@PathVariable(value = "id")int id) {
    
    	return service.getBook(id);
    }
    
//    @RequestMapping("/citys")
//    Relation getCitys(HttpServletRequest request) {
// 
//    	 return service.getRelation();
//    }
//    
//    @RequestMapping("/relations")
//    Relation getRelation(HttpServletRequest request) {
// 
//    	 return service.getRelation();
//    }
    
    @RequestMapping (value="{a}",produces="application/json;charset=UTF-8")   
    public List<Map<String,Object>> data1(HttpServletRequest request) {    
   
    	return dealData(request);
    } 
    
    @RequestMapping (value="{a}/{b}",produces="application/json;charset=UTF-8")  
    public List<Map<String,Object>> data2(HttpServletRequest request) {  
    	
    	return dealData(request);
   
    }  
    
    @RequestMapping (value="{a}/{b}/{c}",produces="application/json;charset=UTF-8")  
    public List<Map<String,Object>> data3(HttpServletRequest request) {  

    	return dealData(request);
    } 
    
    
    List<Map<String,Object>> dealData(HttpServletRequest request)
    {
	       
    	   String  contextpath = request.getScheme() +"://" + request.getServerName()  
	        
	                                + ":" +request.getServerPort() 
	        
	                                + request.getServletPath();
	        
	                if (request.getQueryString() != null){
	        
	                	contextpath += "?" + request.getQueryString();
	        
	                }
	        
		System.out.println("request.getServerName() " + request.getServerName());
		System.out.println("request.getServerPort() " + request.getServerPort());

		System.out.println("request.getServletPath() " + request.getServletPath());
		System.out.println("request.getRequestURI() " +  request.getRequestURI());


	        Relation relation = userDao.findUserSql(contextpath);
	        if(relation!=null)
	        {
	            System.out.println("### sql = " + relation.getSql());
	            
	            return getRelation(relation.getSql());
	            
	        }

	        return null;
    }
    
    @RequestMapping(value="/check/{sql}",produces="application/json;charset=UTF-8")
    List<Map<String,Object>> getRelation(@PathVariable(value = "sql")String sql) {
 
            System.out.println("### sql = " + sql);
            List<Map<String,Object>> mapList= userDao.getInfo(sql);
       
    	 return mapList;
        
    }
}