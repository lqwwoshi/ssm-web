package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javabeans.Data;
import com.javabeans.Enroll;
import com.javabeans.Login;
import com.javabeans.Notice;
import com.javabeans.Teacher;
import com.service.LoginService;
import com.service.StuService;

@Controller
public class StuPublicSelect {
	@Autowired
	private LoginService loginService;
	@Autowired
	private StuService stuservice;

	@RequestMapping(value = "/getAllNotice", method = { RequestMethod.GET })
	@ResponseBody
	public List<Notice> getAllNotice(HttpServletRequest reques) {
		HttpSession session=reques.getSession();
		Login login=(Login) session.getAttribute("user");
		/*String sno=reques.getParameter("sno");*/
		List<Notice> noticeList = stuservice.getAllNotice(login.getUsername());
		System.out.println("notice");
		// 返回结果
		return noticeList;
	}

	@RequestMapping(value = "/getEnrollByStuNo", method = { RequestMethod.GET })
	@ResponseBody
	public List getEnrollByStuNo(HttpServletRequest reques) {
		// 把查询结果传递给页面
		HttpSession session=reques.getSession();
		Login login=(Login) session.getAttribute("user");
		/*String sno=reques.getParameter("sno");*/
		List<Enroll> enrollList = stuservice.getEnrollByStuNo(login.getUsername());
		System.out.println("getEnrollByStuNo");
		return enrollList;
	}

	@RequestMapping(value = "/getAllTeacher", method = { RequestMethod.GET })
	@ResponseBody
	public List<Teacher> getAllTeacher(HttpServletRequest reques) {
		// 把查询结果传递给页面
		List<Teacher> teList = stuservice.getAllTeacher();
		System.out.println("getAllTeacher");
		return teList;
	}

	@RequestMapping(value = "/getDataByTeachNo", method = { RequestMethod.GET })
	@ResponseBody
	public List<Data> getDataByTeachNo(HttpServletRequest reques) {
		// 把查询结果传递给页面
		ModelAndView modelAndView = new ModelAndView();
		String teachNo = reques.getParameter("teachno");
		List<Data> dataList = stuservice.getDataByTeachNo(teachNo);
		System.out.println("getDataByTeachNo");
		// 返回结果
		return dataList;
	}

	@RequestMapping(value = "/downloadData", method = { RequestMethod.POST })
	@ResponseBody
	public void downloadData(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		System.out.println("downloadData");
		String filepath = "";
		String filename = "";

		filepath = new String(request.getParameter("path"));
		filename = new String(request.getParameter("name"));

		System.out.println(filepath + filename);
		File file = new File(filepath + filename);
		try {
			// 设置文件的内容类型
			response.setContentType("multipart/form-data");
			// 设置Content-Disposition响应头，指定文件名
			response.setHeader("Content-Disposition", "attachment;filename=" + filename);
			FileInputStream fis = new FileInputStream(file);
			BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
			byte[] buffer = new byte[1024];
			int len;
			while ((len = fis.read(buffer)) != -1) {
				out.write(buffer, 0, len);
				out.flush();
			}

			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
