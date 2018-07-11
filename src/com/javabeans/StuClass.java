package com.javabeans;

import java.io.Serializable;

public class StuClass implements Serializable{
		String classNo;
		String className;
		String collegeNo;
		College college;
		public String getClassNo() {
			return classNo;
		}
		public void setClassNo(String classNo) {
			this.classNo = classNo;
		}
		public String getClassName() {
			return className;
		}
		public void setClassName(String className) {
			this.className = className;
		}
		public String getCollegeNo() {
			return collegeNo;
		}
		public void setCollegeNo(String collegeNo) {
			this.collegeNo = collegeNo;
		}
		public College getCollege() {
			return college;
		}
		public void setCollege(College college) {
			this.college = college;
		}
		
}
