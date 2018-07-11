package com.controller;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.service.LoginService;
import com.javabeans.Course;
import com.javabeans.Login;
import com.javabeans.Notice;
import com.javabeans.Student;
import com.service.*;
@Controller
public class TePubSign {
	@Autowired
	private TeService teService;
	
		@RequestMapping(value="/getSignedStudent",method={RequestMethod.POST})
	    @ResponseBody
	    public  List<Student> getAllSignedStudent(HttpServletRequest reques) throws UnsupportedEncodingException {
			String pubId=reques.getParameter("pubId");
	        List<Student> signStudentList = teService.getSignStudent(Integer.parseInt(pubId));
	        System.out.println("signStuent");
	        // 返回结果
	        return signStudentList;
	    }
	 	@RequestMapping(value="/getUnSignStudent",method={RequestMethod.POST})
	    @ResponseBody
	    public  List<Student> getAllUnSignedStudent(HttpServletRequest reques) {
	 			String pubId=reques.getParameter("pubId");
	 		 	Calendar date = Calendar.getInstance(); 
			    int year = date.get(Calendar.YEAR);
			    String semester="";
			    int month = date.get(Calendar.MONTH) + 1;
			    if(month>=2&&month<=8)
			    {
			    	semester=year-1+"/"+year+"(2)";
			    }
			    else
			    {
			    	semester=year+"/"+year+1+"(1)";
			    }
	        List<Student> unSignStudentList = teService.getUnSignStudent(Integer.parseInt(pubId),semester);
	        System.out.println("unSignStuent");
	        // 返回结果
	        return unSignStudentList; 
	    }
	 	
	 	@RequestMapping(value="/publishSign",method={RequestMethod.POST})
	    @ResponseBody
	    public  int publishSign(HttpServletRequest reques) {
	 		/*String tno=reques.getParameter("tno");*/
	 		HttpSession session=reques.getSession();
	 		Login login=(Login) session.getAttribute("user");
	 		String cname=reques.getParameter("cname");
	        /*System.out.println(reques.getParameter("time"));*/
	        Timestamp time=Timestamp.valueOf(reques.getParameter("time"));
	        double lo=Double.parseDouble(reques.getParameter("lo"));
	        double la=Double.parseDouble(reques.getParameter("la"));
	        int pubId = teService.publishSign(login.getUsername(),cname,time,"开启",lo,la);
	        System.out.println("publishSign");
	        // 返回结果
	        return pubId;
	    }
	 	
	 	@RequestMapping(value="/closeSign",method={RequestMethod.POST})
	    @ResponseBody
	    public  boolean closeSign(HttpServletRequest reques) {
	        // 把查询结果传递给页面
	 		String pubId=reques.getParameter("pubId");
	        boolean stop=teService.closeSign(Integer.parseInt(pubId));
	        System.out.println("closeSign");
	        // 返回结果
	        return stop;
	    }
	 	
		@RequestMapping(value="/teSelectCourPubsign",method={RequestMethod.GET})
	    @ResponseBody
	    public  ArrayList<Course> teSelectCourPubsign(HttpServletRequest reques) {
	        // 把查询结果传递给页面
			HttpSession session=reques.getSession();
			Login login=(Login) session.getAttribute("user");
		/*	String tno=reques.getParameter("tno");*/
	        Calendar date = Calendar.getInstance(); 
		    int year = date.get(Calendar.YEAR);
		    String semester="";
		    int month = date.get(Calendar.MONTH) + 1;
		    if(month>=2&&month<=8)
		    {
		    	semester=year-1+"/"+year+"(2)";
		    }
		    else
		    {
		    	semester=year+"/"+year+1+"(1)";
		    }
			/*System.out.println(semester); */
	        ArrayList<Course> courseList=teService.teSelectCourPubsign(login.getUsername(),semester);
	        System.out.println("teSelectCourPubsign");
	        // 返回结果
	        return courseList;
	    }
}
