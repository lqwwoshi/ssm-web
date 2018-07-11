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
				);//�����㵽����
		public ArrayList<Student> getSignStudent(@Param("pubId")int pubId);//��ȡ�����ѵ㵽��ѧ��
		public ArrayList<Student> getUnSignStudent(@Param("pubId")int pubId,@Param("semester")String semester);//��ȡ����δ�㵽��ѧ��
		public int closeSign(@Param("pubId")int pubId);//�رոոտ����ĵ㵽
		public Teacher getTeacherIm(@Param("tno")String tno);
		public ArrayList<Student> getAllStudent();
		public ArrayList<Course> teGetEnrollCourse(@Param("tno")String tno,@Param("semester")String semester);
		public ArrayList<Student> teGetEnroCourStudent(@Param("tno")String tno,@Param("semester")String semester,
				@Param("cname")String cname);
}
