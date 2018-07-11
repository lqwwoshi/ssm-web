package com.javabeans;

import java.io.Serializable;

public class Student implements Serializable{
		String sno;
		String sname;
		String sex;
		String phoneNumber;
		String classNo;
		StuClass  stuclass;
		public String getSno() {
			return sno;
		}
		public void setSno(String sno) {
			this.sno = sno;
		}
		public String getSname() {
			return sname;
		}
		public void setSname(String sname) {
			this.sname = sname;
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
		public StuClass getStuclass() {
			return stuclass;
		}
		public void setStuclass(StuClass stuclass) {
			this.stuclass = stuclass;
		}
		public String getClassNo() {
			return classNo;
		}
		public void setClassNo(String classNo) {
			this.classNo = classNo;
		}
		
}
