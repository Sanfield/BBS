package com.class2bbs.bean;

import java.sql.Date;
import java.sql.Time;

public class BoardBean {
	private String boId;
	private String boName;
	private Date boDate;
	private Time boTime;
	private String boFlag;
	public BoardBean() {
	}
	public String getBoId() {
		return boId;
	}
	public void setBoId(String boId) {
		this.boId = boId;
	}
	public String getBoName() {
		return boName;
	}
	public void setBoName(String boName) {
		this.boName = boName;
	}
	public Date getBoDate() {
		return boDate;
	}
	public void setBoDate(Date boDate) {
		this.boDate = boDate;
	}
	public Time getBoTime() {
		return boTime;
	}
	public void setBoTime(Time boTime) {
		this.boTime = boTime;
	}
	public String getBoFlag() {
		return boFlag;
	}
	public void setBoFlag(String boFlag) {
		this.boFlag = boFlag;
	}
}
