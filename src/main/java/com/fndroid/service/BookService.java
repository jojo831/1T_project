package com.fndroid.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fndroid.dao.UserDao;
import com.fndroid.entity.Book;
import com.fndroid.entity.City;
import com.fndroid.entity.Relation;

@Service
public class BookService {

	@Resource
	UserDao userDao;

	public List<Book> getBooks() {
    	List<Book> bookList = new ArrayList<Book>();
    	Book book= new Book();
    	book.setId(1);
    	book.setTitle("killer");
    	book.setDescription("please read it");
    	bookList.add(book);
    	
        return bookList;
    }

	public Book getBook(int id){
    	Book book= new Book();
    	book.setId(id);
    	book.setTitle("learner");
    	book.setDescription("please learn it");
    	return book;
	}
    	
    public Relation getRelation(){
    	
		Relation relation = userDao.findUserInfo();
		return relation;
		
    }
    	
    public City getCityInfo(String code){
    	
		City city = userDao.findCityInfo(code);
		return city;
		
    }
}