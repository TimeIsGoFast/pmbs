package net.zjwu.mis.business.dto;

public class UserDto {
	private int userid;
    private String uid;
    private String name;
    private String mail;
    private int roid;
    private String rolename;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getRoid() {
		return roid;
	}
	public void setRoid(int roid) {
		this.roid = roid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
    
    
}
