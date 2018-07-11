package com.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.javabeans.AttendPub;
import com.javabeans.Attendance;
import com.javabeans.Course;
import com.javabeans.Data;
import com.javabeans.Enroll;
import com.javabeans.Notice;
import com.javabeans.Student;
import com.javabeans.Teacher;

public interface StudentMapper {
		public List<Notice> getAllNotice(String stu_no);
		public List<Enroll> getEnrollByStuNo(String stu_no);
		public AttendPub findPub(@Param("sno")String sno,@Param("cname")String cname);
		public Attendance repeatSign(@Param("pubId")int pubId,@Param("sno")String sno);
		public int signIn(@Param("pubId")int pubId,@Param("sno")String sno,@Param("time")
		Timestamp time,@Param("state")String state);
		public ArrayList<Enroll> stuSelectCourSign(@Param("sno")String sno,@Param("semester")String semester);
		public List<Teacher> getAllTeacher();
		public Student getStudentIm(@Param("sno")String sno);
		public List<Data> getDataByTeachNo(String teach_no);
		
}
