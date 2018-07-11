package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javabeans.Login;
import com.javabeans.Student;
import com.javabeans.Teacher;
import com.service.StuService;
import com.service.TeService;

@Controller
public class TePersonal {
	@Autowired
	private TeService teService;
	
    @RequestMapping(value="/getTeacherIm",method={RequestMethod.GET})
    @ResponseBody
    public  Teacher getTeacherIm(HttpServletRequest reques) {
    	HttpSession session=reques.getSession();
		Login login=(Login) session.getAttribute("user");
    	/*String tno=reques.getParameter("tno");;*/
        Teacher teacher = teService.getTeacherIm(login.getUsername());
        System.out.println("getTeacherIm");
        // ·µ»Ø½á¹û
        return teacher;
    }
}
