package com.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Data implements Serializable{
	private String data_no;
	private String teach_no;
	private String data_adr;
	private Timestamp data_Time;
	
	public String getData_no() {
		return data_no;
	}
	public void setData_no(String data_no) {
		this.data_no = data_no;
	}
	public String getTeach_no() {
		return teach_no;
	}
	public void setTeach_no(String teach_no) {
		this.teach_no = teach_no;
	}
	public String getData_adr() {
		return data_adr;
	}
	public void setData_adr(String data_adr) {
		this.data_adr = data_adr;
	}
	public Timestamp getData_Time() {
		return data_Time;
	}
	public void setData_Time(Timestamp data_Time) {
		this.data_Time = data_Time;
	}
	
}
