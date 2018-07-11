package com.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Attendance implements Serializable{
		int attendNo;
		int pubId;
		String sno;
		Timestamp attendTime;
		String attendance;
		public int getAttendNo() {
			return attendNo;
		}
		public void setAttendNo(int attendNo) {
			this.attendNo = attendNo;
		}
		public int getPubId() {
			return pubId;
		}
		public void setPubId(int pubId) {
			this.pubId = pubId;
		}
		public String getSno() {
			return sno;
		}
		public void setSno(String sno) {
			this.sno = sno;
		}
		public Timestamp getAttendTime() {
			return attendTime;
		}
		public void setAttendTime(Timestamp attendTime) {
			this.attendTime = attendTime;
		}
		public String getAttendance() {
			return attendance;
		}
		public void setAttendance(String attendance) {
			this.attendance = attendance;
		}
		
}
