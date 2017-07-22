package com.class2bbs.bean;

public class ProvinceBean {
	private String pid;
	private String pname;
	public ProvinceBean() {
	}
	public ProvinceBean(String pid, String pname) {
		this.pid = pid;
		this.pname = pname;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	} 
}
