package com.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javabeans.Login;
import com.javabeans.Notice;
import com.javabeans.Student;
import com.service.LoginService;
import com.service.StuService;

@Controller
public class StuPersonal {
	@Autowired
	private StuService Stuservice;
	

    @RequestMapping(value="/getStudentIm",method={RequestMethod.POST})
    @ResponseBody
    public  Student getStudentIm(HttpServletRequest reques) {
    	HttpSession session=reques.getSession();
    /*	Cookie[] a=reques.getCookies();
    	for(Cookie cookie : a)
    	{
    		System.out.println(cookie.getValue());
    	}*/
		Login login=(Login) session.getAttribute("user");
    	/*String sno=reques.getParameter("sno");
    	if(login!=null)
    		System.out.println(login.getUsername()+"a");*/
        Student student = Stuservice.getStudentIm(login.getUsername());
        System.out.println("getStudentIm");
        // ·µ»Ø½á¹û
        return student;
    }
    
}
