package com.service;

import java.util.List;


import com.javabeans.Login;
import com.javabeans.News;

public interface LoginService {
		public Login getUser(String username,String password);
		public List<News> getAllNews();
		public Boolean updatePass(String username,String oldPassword,String newPassword);
}
