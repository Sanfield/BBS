package com.class2bbs.bean;

import java.sql.Date;
import java.sql.Time;

public class ReplyBlogBean {
	private Integer rbId;
	private String rbText;
	private Date rbDate;
	private Time rbTime;
	private String uname;
	private Integer blId;
	private String rbDelete;
	
	private String photo;
	private Date regDate;
	
	public ReplyBlogBean() {
	}
	public Integer getRbId() {
		return rbId;
	}
	public void setRbId(Integer rbId) {
		this.rbId = rbId;
	}
	public String getRbText() {
		return rbText;
	}
	public void setRbText(String rbText) {
		this.rbText = rbText;
	}
	public Date getRbDate() {
		return rbDate;
	}
	public void setRbDate(Date rbDate) {
		this.rbDate = rbDate;
	}
	public Time getRbTime() {
		return rbTime;
	}
	public void setRbTime(Time rbTime) {
		this.rbTime = rbTime;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Integer getBlId() {
		return blId;
	}
	public void setBlId(Integer blId) {
		this.blId = blId;
	}
	public String getRbDelete() {
		return rbDelete;
	}
	public void setRbDelete(String rbDelete) {
		this.rbDelete = rbDelete;
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
