package com.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.javabeans.Course;
import com.javabeans.Student;
import com.javabeans.Teacher;

public interface TeacherMapper {
	    public ArrayList<Course> teSelectCourPubsign(@Param("tno")String tno,@Param("semester")String semester);
		public int publishSign(@Param("tno")String tno,@Param("cname")String cname,@Param("time")Timestamp time,
				@Param("state")String state,@Param("longitude")double longitude,@Param("latitude") double
				latitude
				);//发布点到任务
		public ArrayList<Student> getSignStudent(@Param("pubId")int pubId);//获取所有已点到的学生
		public ArrayList<Student> getUnSignStudent(@Param("pubId")int pubId,@Param("semester")String semester);//获取所有未点到的学生
		public int closeSign(@Param("pubId")int pubId);//关闭刚刚开启的点到
		public Teacher getTeacherIm(@Param("tno")String tno);
		public ArrayList<Student> getAllStudent();
		public ArrayList<Course> teGetEnrollCourse(@Param("tno")String tno,@Param("semester")String semester);
		public ArrayList<Student> teGetEnroCourStudent(@Param("tno")String tno,@Param("semester")String semester,
				@Param("cname")String cname);
}
