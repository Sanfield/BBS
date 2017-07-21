package com.bbsmng.bean;

public class CityBean {
	private String cid;
	private String cname;
	private String father;
	public CityBean() {
	}
	public CityBean(String cid, String cname, String father) {
		this.cid = cid;
		this.cname = cname;
		this.father = father;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	} 
}
