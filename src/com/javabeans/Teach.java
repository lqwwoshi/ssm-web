package com.javabeans;

import java.io.Serializable;

public class Teach implements Serializable{
	private String teach_no;
	private String classroom;
    private int day;
    private int startTime;
    private int endTime;
    private Course course;
    private Teacher teacher;
    
    public String getTeach_no() {
		return teach_no;
	}
	public void setTeach_no(String teach_no) {
		this.teach_no = teach_no;
	}
    public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
}
