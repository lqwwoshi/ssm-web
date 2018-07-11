package com.controller;

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

import com.javabeans.AttendPub;
import com.javabeans.Enroll;
import com.javabeans.Login;
import com.service.StuService;

@Controller
public class StuSign {
	@Autowired
	private StuService stuService;

	@RequestMapping(value = "/stuSelectCourSign", method = { RequestMethod.GET  })
		
	public ArrayList<Enroll> stuSelectCourSign(HttpServletRequest reques) {
		// �Ѳ�ѯ������ݸ�ҳ��
		String sno=reques.getParameter("sno");
	/*	HttpSession session=reques.getSession();
		Login login=(Login) session.getAttribute("user");*/
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
		ArrayList<Enroll> selectList = stuService.stuSelectCourSign(sno,semester);
		System.out.println(selectList.get(0).getTeach().getTeacher().getTname());
		System.out.println(selectList.size());
		System.out.println("stuSelectCourSign");
		// ���ؽ��
		return selectList;
	}

	@RequestMapping(value = "/findPub", method = { RequestMethod.POST })
	@ResponseBody
	public AttendPub findPub(HttpServletRequest reques) {
		// �Ѳ�ѯ������ݸ�ҳ��
		HttpSession session=reques.getSession();
		Login login=(Login) session.getAttribute("user");
		/*String sno=reques.getParameter("sno");*/
		String cname=reques.getParameter("cname");
		AttendPub attendPub = stuService.findPub(login.getUsername(), cname);
		System.out.println("findPubId");
		// ���ؽ��
		return attendPub;
	}

	@RequestMapping(value = "/repeatSign", method = { RequestMethod.POST })
	@ResponseBody
	public boolean repeatSign(HttpServletRequest reques) {
		// �Ѳ�ѯ������ݸ�ҳ��
		String pubId=reques.getParameter("pubId");
		HttpSession session=reques.getSession();
		Login login=(Login) session.getAttribute("user");
		/*String sno=reques.getParameter("sno");*/
		boolean repeatSign = stuService.repeatSign(Integer.parseInt(pubId), login.getUsername());
		System.out.println("repeatSign");
		// ���ؽ��
		return repeatSign;
	}

	@RequestMapping(value = "/stuSignIn", method = { RequestMethod.POST })
	@ResponseBody
	public boolean stusignIn(HttpServletRequest reques) {
		String pubId=reques.getParameter("pubId");
		/*String sno=reques.getParameter("sno");*/
		HttpSession session=reques.getSession();
		Login login=(Login) session.getAttribute("user");
		String timeStamp=reques.getParameter("timeStamp");
		boolean sign = stuService.signIn(Integer.parseInt(pubId),login.getUsername(), Timestamp.valueOf(timeStamp), "ǩ��");
		System.out.println("stusignIn");
		// ���ؽ��
		return sign;
	}
}
