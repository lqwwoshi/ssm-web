package com.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Notice implements Serializable{
	private String noticeNo;
	private String classNo;
	private String noticeTitle;
	private String noticeCont;
	private Timestamp noticeTime;
	
	public String getClassNo() {
		return classNo;
	}
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	public String getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(String noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeCont() {
		return noticeCont;
	}
	public void setNoticeCont(String noticeCont) {
		this.noticeCont = noticeCont;
	}
	public Timestamp getNoticeTime() {
		return noticeTime;
	}
	public void setNoticeTime(Timestamp noticeTime) {
		this.noticeTime = noticeTime;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	
	
	

}
