package com.class2bbs.bean;

import java.sql.Date;
import java.sql.Time;

public class ChildBoardBean {
	private String cbId;
	private String cboName;
	private String boaId;
	private Date cboDate;
	private Time cboTime;
	private String cboFlag;
	
	private Integer cnt;//��ǰ2����鷢��������
	
	private BlogBean blog;//��ǰ2���������һ�η���
	
	public ChildBoardBean() {
	}
	public String getCbId() {
		return cbId;
	}
	public void setCbId(String cbId) {
		this.cbId = cbId;
	}
	public String getCboName() {
		return cboName;
	}
	public void setCboName(String cboName) {
		this.cboName = cboName;
	}
	public String getBoaId() {
		return boaId;
	}
	public void setBoaId(String boaId) {
		this.boaId = boaId;
	}
	public Date getCboDate() {
		return cboDate;
	}
	public void setCboDate(Date cboDate) {
		this.cboDate = cboDate;
	}
	public Time getCboTime() {
		return cboTime;
	}
	public void setCboTime(Time cboTime) {
		this.cboTime = cboTime;
	}
	public String getCboFlag() {
		return cboFlag;
	}
	public void setCboFlag(String cboFlag) {
		this.cboFlag = cboFlag;
	}
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	public BlogBean getBlog() {
		return blog;
	}
	public void setBlog(BlogBean blog) {
		this.blog = blog;
	} 
}
