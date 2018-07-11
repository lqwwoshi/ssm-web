package com.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabeans.Course;
import com.javabeans.Student;
import com.javabeans.Teacher;
import com.mapper.TeacherMapper;
import com.service.TeService;
@Service
public class TeServiceImpl implements TeService{
	@Autowired
	private TeacherMapper teacherMapper;
	/*public void publishSign(String tno,String cname);//发布点到任务*/
	@Override
	public ArrayList<Student> getSignStudent(int pubId)//获取所有已点到的学生
	{
		List<Student> signStudentList=teacherMapper.getSignStudent(pubId);
		return (ArrayList<Student>) signStudentList;
	}
	@Override
	public ArrayList<Student> getUnSignStudent(int pubId,String semester) {
		// TODO Auto-generated method stub
		List<Student> unSignStudentList=teacherMapper.getUnSignStudent(pubId,semester);
		return (ArrayList<Student>) unSignStudentList;
	}
	@Override
	public int publishSign(String tno, String cname,Timestamp time,String state,double lo,double la) {
		// TODO Auto-generated method stub
		int pubId=teacherMapper.publishSign(tno, cname,time,state,lo,la);
		return pubId;
		
	}
	@Override
	public boolean closeSign(int pubId)
	{
		if(teacherMapper.closeSign(pubId)==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	@Override
	public ArrayList<Course> teSelectCourPubsign(String tno, String semester) {
		// TODO Auto-generated method stub
		return teacherMapper.teSelectCourPubsign(tno, semester);
	}
	
	@Override
	public Teacher getTeacherIm(String tno)
	{
		return teacherMapper.getTeacherIm(tno);
	}
	@Override
	public ArrayList<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return teacherMapper.getAllStudent();
	}
	@Override
	public ArrayList<Course> teGetEnrollCourse(String tno, String semester) {
		// TODO Auto-generated method stub
		return teacherMapper.teGetEnrollCourse(tno, semester);
	}
	@Override
	public ArrayList<Student> teGetEnroCourStudent(String tno, String semester, String cname) {
		// TODO Auto-generated method stub
		return teacherMapper.teGetEnroCourStudent(tno, semester, cname);
	}
	
}
