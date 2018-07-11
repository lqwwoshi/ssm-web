package com.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabeans.AttendPub;
import com.javabeans.Attendance;
import com.javabeans.Course;
import com.javabeans.Data;
import com.javabeans.Enroll;
import com.javabeans.Login;
import com.javabeans.Notice;
import com.javabeans.Student;
import com.javabeans.Teacher;
import com.mapper.LoginMapper;
import com.mapper.StudentMapper;
import com.service.StuService;
@Service
public class StuServiceImpl implements StuService{
	@Autowired
	private StudentMapper studentMapper;
	@Override
	public List<Notice> getAllNotice(String stu_no) {
		// TODO Auto-generated method stub
		List<Notice> noticeList=studentMapper.getAllNotice(stu_no);
		return noticeList;
	}

	public List<Enroll> getEnrollByStuNo(String stu_no){
		// TODO Auto-generated method stub
		List<Enroll> enrollList=studentMapper.getEnrollByStuNo(stu_no);
		return enrollList;
	}
	public AttendPub findPub(String sno,String cname)
	{
		return studentMapper.findPub(sno, cname);
	}

	@Override
	public boolean repeatSign(int pubId, String sno) {
		// TODO Auto-generated method stub
		Attendance attendance=studentMapper.repeatSign(pubId, sno);
		if(attendance!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean signIn(int pubId, String sno, Timestamp time, String state) {
		// TODO Auto-generated method stub
		int sign=studentMapper.signIn(pubId, sno, time, state);
		if(sign!=0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public ArrayList<Enroll> stuSelectCourSign(String sno,String semester)
	{
		return studentMapper.stuSelectCourSign(sno, semester);
	}

	@Override
	public List<Teacher> getAllTeacher() {
		// TODO Auto-generated method stub
		return studentMapper.getAllTeacher();
	}
	
	@Override
	public Student getStudentIm(String sno)
	{
		return studentMapper.getStudentIm(sno);
	}

	@Override
	public List<Data> getDataByTeachNo(String teach_no){
		List<Data> dataList=studentMapper.getDataByTeachNo(teach_no);
		return dataList;
	}
}
