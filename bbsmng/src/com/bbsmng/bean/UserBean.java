package com.bbsmng.bean;

import java.sql.Date;
import java.sql.Time;

public class UserBean {
	private String uname;
	private String upass;
	private String pid;
	private String cid;
	private String usex;
	private String uphoto;
	private Date uregDate;
	private Time uregTime;
	private String uadmin;
	private String uflag;
	
	private String pname;
	private String cname;
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public UserBean() {
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public String getUphoto() {
		return uphoto;
	}
	public void setUphoto(String uphoto) {
		this.uphoto = uphoto;
	}
	public Date getUregDate() {
		return uregDate;
	}
	public void setUregDate(Date uregDate) {
		this.uregDate = uregDate;
	}
	public Time getUregTime() {
		return uregTime;
	}
	public void setUregTime(Time uregTime) {
		this.uregTime = uregTime;
	}
	public String getUadmin() {
		return uadmin;
	}
	public void setUadmin(String uadmin) {
		this.uadmin = uadmin;
	}
	public String getUflag() {
		return uflag;
	}
	public void setUflag(String uflag) {
		this.uflag = uflag;
	}
	@Override
	public String toString() {
		return "UserBean [uname=" + uname + ", upass=" + upass + ", pid=" + pid
				+ ", cid=" + cid + ", usex=" + usex + ", uphoto=" + uphoto
				+ ", uregDate=" + uregDate + ", uregTime=" + uregTime
				+ ", uadmin=" + uadmin + ", uflag=" + uflag + "]";
	} 
}
