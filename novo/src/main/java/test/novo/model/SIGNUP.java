package test.novo.model;

import java.util.LinkedHashMap;

public class SIGNUP {
  private Integer empId;
  private String email;
  private String phoneNo;
  private String firstName;
  private String lastName;
  private String password;
  private String middleName;
  private Integer userAccess;
  private LinkedHashMap <Integer,String> usertype;
  public SIGNUP() {
	  usertype=new LinkedHashMap <Integer,String>();
	  usertype.put(1,"Admin 1");
	  usertype.put(2,"Admin 2");
	  usertype.put(3,"Employee");
   
  }
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getMiddleName() {
	return middleName;
}
public void setMiddleName(String middleName) {
	this.middleName = middleName;
}
public LinkedHashMap <Integer,String> getUsertype() {
	return usertype;
}
public Integer getEmpId() {
	return empId;
}
public void setEmpId(Integer empId) {
	this.empId = empId;
}
public Integer getUserAccess() {
	return userAccess;
}
public void setUserAccess(Integer userAccess) {
	this.userAccess = userAccess;
}
public String getPassword() {
	  password=email+empId;
      return password;
}







}
