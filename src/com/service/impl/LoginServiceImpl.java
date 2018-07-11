package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabeans.Login;
import com.javabeans.News;
import com.service.LoginService;
import com.mapper.*;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginMapper loginMapper;
	@Override
	public Login getUser(String username,String password) {
		// TODO Auto-generated method stub
		Login user=loginMapper.getUser(username,password);
		return user;

	}
	@Override
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		return loginMapper.getAllNews();
	}
	
	@Override
	public Boolean updatePass(String username,String oldPassword,String newPassword){
		// TODO Auto-generated method stub
		return loginMapper.updatePass(username, oldPassword,newPassword);
	}
		
}
