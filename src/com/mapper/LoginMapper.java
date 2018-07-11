package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.javabeans.Login;
import com.javabeans.News;

public interface LoginMapper {
		Login getUser(@Param("username")String username,@Param("password")String password);
		List<News> getAllNews();
		public Boolean updatePass(@Param("username")String username,@Param("oldPassword")String oldPassword,
				@Param("newPassword")String newPassword);
}
