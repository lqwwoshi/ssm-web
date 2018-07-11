package com.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javabeans.Course;
import com.javabeans.Login;
import com.javabeans.Notice;
import com.javabeans.Student;
import com.service.LoginService;
import com.service.TeService;

@Controller
public class TePublicSelect {
	@Autowired
	private TeService teService;

	@RequestMapping(value = "/getAllStudent", method = { RequestMethod.GET })
	@ResponseBody
	public List<Student> getAllStudent(HttpServletRequest reques) {
		// 把查询结果传递给页面
		List<Student> stuList = teService.getAllStudent();
		System.out.println("getAllStudent");
		// 返回结果
		return stuList;
	}

	@RequestMapping(value = "/teGetEnrollCourse", method = { RequestMethod.POST })
	@ResponseBody
	public List<Course> teGetEnrollCoursee(HttpServletRequest reques) {
		// 把查询结果传递给页面
		/*String tno = reques.getParameter("tno");*/
		HttpSession session=reques.getSession();
		Login login=(Login) session.getAttribute("user");
		String semester = reques.getParameter("semester");
		if (semester == "") {
			Calendar date = Calendar.getInstance();
			int year = date.get(Calendar.YEAR);
			int month = date.get(Calendar.MONTH) + 1;
			if (month >= 2 && month <= 8) {
				semester = year - 1 + "/" + year + "(2)";
			} else {
				semester = year + "/" + year + 1 + "(1)";
			}
		}
		List<Course> courList = teService.teGetEnrollCourse(login.getUsername(), semester);
		System.out.println("teGetEnrollCourse");
		// 返回结果
		return courList;
	}
	
	@RequestMapping(value = "/teGetEnroCourStudent", method = { RequestMethod.POST })
	@ResponseBody
	public List<Student> teGetEnroCourStudent(HttpServletRequest reques) {
		// 把查询结果传递给页面
		HttpSession session=reques.getSession();
		Login login=(Login) session.getAttribute("user");
		/*String tno=reques.getParameter("tno");*/
		String tname=reques.getParameter("semester");
		String cname=reques.getParameter("cname");
		List<Student> stuList = teService.teGetEnroCourStudent(login.getUsername(),tname,cname);
		System.out.println("teGetEnroCourStudent");
		// 返回结果
		return stuList;
	}
}
