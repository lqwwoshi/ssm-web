package com.javabeans;

import java.io.Serializable;

public class Teacher implements Serializable{
		String tno;
		String tname;
		String sex;
		String phoneNumber;
		String collegeNo;
		College college;
		AttendPub attendPub;
		public String getTno() {
			return tno;
		}
		public void setTno(String tno) {
			this.tno = tno;
		}
		public String getTname() {
			return tname;
		}
		public void setTname(String tname) {
			this.tname = tname;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public College getCollege() {
			return college;
		}
		public void setCollege(College college) {
			this.college = college;
		}
		
}
