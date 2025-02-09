package com.jsp.dto;

public class Employee {
 private int eId;
 private String eName;
 private long phoneNo;
 private String email;
 private String password;
public Employee(int eId, String eName, long phoneNo, String email, String password) {
	super();
	this.eId = eId;
	this.eName = eName;
	this.phoneNo = phoneNo;
	this.email = email;
	this.password = password;
}
public Employee() {
}
public int geteId() {
	return eId;
}
public void seteId(int eId) {
	this.eId = eId;
}
public String geteName() {
	return eName;
}
public void seteName(String eName) {
	this.eName = eName;
}
public long getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(long phoneNo) {
	this.phoneNo = phoneNo;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
 
}
