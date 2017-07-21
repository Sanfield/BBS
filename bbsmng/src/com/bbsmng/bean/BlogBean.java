package com.bbsmng.bean;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.annotation.WebServlet;

public class BlogBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer blId;
	private String blTitle;
	private String blText;
	private Date blDate;
	private Time blTime;
	private String uname;
	private String cbId;
	private String blDelete;
	
	private Integer replyCount;//当前帖子回复数
	
	private String photo;
	private Date regDate;
	
	private String childName;
	
	public String getChildName() {
		return childName;
	}
	public void setChildName(String childName) {
		this.childName = childName;
	}
	public BlogBean() {
	}
	public Integer getBlId() {
		return blId;
	}
	public void setBlId(Integer blId) {
		this.blId = blId;
	}
	public String getBlTitle() {
		return blTitle;
	}
	public void setBlTitle(String blTitle) {
		this.blTitle = blTitle;
	}
	public String getBlText() {
		return blText;
	}
	public void setBlText(String blText) {
		this.blText = blText;
	}
	public Date getBlDate() {
		return blDate;
	}
	public void setBlDate(Date blDate) {
		this.blDate = blDate;
	}
	public Time getBlTime() {
		return blTime;
	}
	public void setBlTime(Time blTime) {
		this.blTime = blTime;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getCbId() {
		return cbId;
	}
	public void setCbId(String cbId) {
		this.cbId = cbId;
	}
	public String getBlDelete() {
		return blDelete;
	}
	public void setBlDelete(String blDelete) {
		this.blDelete = blDelete;
	}
	public Integer getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	} 
}
