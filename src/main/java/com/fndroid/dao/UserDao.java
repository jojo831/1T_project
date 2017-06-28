package com.fndroid.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.fndroid.entity.City;
import com.fndroid.entity.Relation;




@Repository
public interface UserDao {

	public Relation findUserInfo();

	public Relation findUserSql(@Param("url")String url);
	
	public City findCityInfo(@Param("code")String code);
	
//	@Select("select * from city")
	@Select("${sql}")
	public List<Map<String,Object>> getInfo(@Param("sql")String sql);
}
