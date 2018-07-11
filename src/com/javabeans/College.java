package com.javabeans;

import java.io.Serializable;

public class College implements Serializable{
		String collegeNo;
		String collegeName;
		public String getCollegeNo() {
			return collegeNo;
		}
		public void setCollegeNo(String collegeNo) {
			this.collegeNo = collegeNo;
		}
		public String getCollegeName() {
			return collegeName;
		}
		public void setCollegeName(String collegeName) {
			this.collegeName = collegeName;
		}
		
}
