package com.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.javabeans.AttendPub;
import com.javabeans.Course;
import com.javabeans.Data;
import com.javabeans.Enroll;
import com.javabeans.Notice;
import com.javabeans.Student;
import com.javabeans.Teacher;

public interface StuService {
		public List<Notice> getAllNotice(String stu_no);
		public List<Enroll> getEnrollByStuNo(String stu_no);
		public AttendPub findPub(String sno,String cname);
		public boolean repeatSign(int pubId,String sno);
		public boolean signIn(int pubId,String sno,Timestamp time,String state);
		public ArrayList<Enroll> stuSelectCourSign(String sno,String semester);
		public List<Teacher> getAllTeacher();
		public Student getStudentIm(String sno);
		public List<Data> getDataByTeachNo(String teach_no);
}
