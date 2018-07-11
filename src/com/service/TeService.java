package com.service;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.javabeans.Course;
import com.javabeans.Student;
import com.javabeans.Teacher;

public interface TeService {
	public ArrayList<Course> teSelectCourPubsign(String tno,String semester);
	public int publishSign(String tno, String cname,Timestamp time,String state,double lo,double la);//�����㵽����
	public ArrayList<Student> getSignStudent(int pubId);//��ȡ�����ѵ㵽��ѧ��
	public ArrayList<Student> getUnSignStudent(int pubId,String semester);
	public boolean closeSign(int pubId);
	public Teacher getTeacherIm(String tno);
	public ArrayList<Student> getAllStudent();
	public ArrayList<Course> teGetEnrollCourse(String tno,String semester);
	public ArrayList<Student> teGetEnroCourStudent(String tno,String semester,
			String cname);
}
