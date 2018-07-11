package com.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;

public class News implements Serializable{
		int newsNo;
		String title;
		String orgin;
		String content;
		Timestamp newsTime;
		public int getNewsNo() {
			return newsNo;
		}
		public void setNewsNo(int newsNo) {
			this.newsNo = newsNo;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getOrgin() {
			return orgin;
		}
		public void setOrgin(String orgin) {
			this.orgin = orgin;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public Timestamp getNewsTime() {
			return newsTime;
		}
		public void setNewsTime(Timestamp newsTime) {
			this.newsTime = newsTime;
		}
		
}
