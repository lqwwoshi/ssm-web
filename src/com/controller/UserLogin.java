package com.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javabeans.Login;
import com.javabeans.News;
import com.service.LoginService;

@Controller
public class UserLogin {
	@Autowired
	private LoginService loginService;

	@RequestMapping(value="/login",method={RequestMethod.POST})
	@ResponseBody
	public Login getUser(HttpServletRequest reques,HttpServletResponse response) throws UnsupportedEncodingException {
		
		String username = reques.getParameter("username");
		String password = reques.getParameter("password");
		Login user = loginService.getUser(username, password);
//		System.out.println(user.getUsername());
		//response.setHeader("Set-Cookie", "username="+username; "path=/"; "max-age=360000);
		if(user!=null)
		{
			HttpSession session=reques.getSession();
			session.setAttribute("user",user);
			Cookie identify=new Cookie("identify",URLEncoder.encode(user.getIdentity(), "UTF-8"));
			Cookie username1=new Cookie("username",username);
			identify.setMaxAge(60*60*24*14);
			username1.setMaxAge(60*60*24*14);
			response.addCookie(identify);
			response.addCookie(username1);
		}
		System.out.println("login");
		return user;
	}

	@RequestMapping(value="/getAllNews",method={RequestMethod.GET})
	@ResponseBody
	public List<News> getAllNews(HttpServletRequest reques) {
		
		List<News> newsList = loginService.getAllNews();
		System.out.println("getAllNews");
		return newsList;
	}

	@RequestMapping(value="/updatePass",method={RequestMethod.POST})
	@ResponseBody
	public Boolean updatePass(HttpServletRequest reques) {
		HttpSession session=reques.getSession();
		Login login=(Login) session.getAttribute("user");
		/*String username=reques.getParameter("username");*/
		String oldPassword=reques.getParameter("oldPassword");
		String newPassword=reques.getParameter("newPassword");
		Boolean updatePass = loginService.updatePass(login.getUsername(),oldPassword,newPassword);
		System.out.println("updatePass");
		return updatePass;
	}
}
