package com.javabeans;

import java.io.Serializable;

public class Enroll implements Serializable{
		private String enroll_no;
		private Double grade;
		private String semester;
		private String teach_no;
		private Teach teach;
		
		public String getEnroll_no() {
			return enroll_no;
		}
		public void setEnroll_no(String enroll_no) {
			this.enroll_no = enroll_no;
		}
		public String getTeach_no() {
			return teach_no;
		}
		public void setTeach_no(String teach_no) {
			this.teach_no = teach_no;
		}
		public Double getGrade() {
			return grade;
		}
		public void setGrade(Double grade) {
			this.grade = grade;
		}
		public String getSemester() {
			return semester;
		}
		public void setSemester(String semester) {
			this.semester = semester;
		}
		public Teach getTeach() {
			return teach;
		}
		public void setTeach(Teach teach) {
			this.teach = teach;
		}
		
}
