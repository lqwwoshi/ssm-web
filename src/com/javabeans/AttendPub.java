package com.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;

public class AttendPub implements Serializable{
		String pubId;
		String teachNo;
		Timestamp pubTime;
		String state;
		double longitude;
		double latitude;
		public String getPubId() {
			return pubId;
		}
		public void setPubId(String pubId) {
			this.pubId = pubId;
		}
		public String getTeachNo() {
			return teachNo;
		}
		public void setTeachNo(String teachNo) {
			this.teachNo = teachNo;
		}
		public Timestamp getPubTime() {
			return pubTime;
		}
		public void setPubTime(Timestamp pubTime) {
			this.pubTime = pubTime;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}

		public double getLongitude() {
		return longitude;
		}

		public void setLongitude(double longitude) {
		this.longitude = longitude;
		}

		public double getLatitude() {
		return latitude;
		}

		public void setLatitude(double latitude) {
		this.latitude = latitude;
		}
}
