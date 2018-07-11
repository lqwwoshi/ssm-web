package com.javabeans;

import java.io.Serializable;

public class Course implements Serializable{
		private String cno;
		private String cname;
		private int hour;
		private String credit;
		private String judge;
		public String getCno() {
			return cno;
		}
		public void setCno(String cno) {
			this.cno = cno;
		}
		public String getCname() {
			return cname;
		}
		public void setCname(String cname) {
			this.cname = cname;
		}
		public int getHour() {
			return hour;
		}
		public void setHour(int hour) {
			this.hour = hour;
		}
		public String getCredit() {
			return credit;
		}
		public void setCredit(String credit) {
			this.credit = credit;
		}
		public String getJudge() {
			return judge;
		}
		public void setJudge(String judge) {
			this.judge = judge;
		}
		
}
