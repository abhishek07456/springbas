package org.userlist.user.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class usermodel {
     private int id;
     private String name;
     private int collegeid;
 public usermodel() {
	 
 }
	public usermodel(int id2, String name2, int collegeid2) {
 		this.id=id2;
   	    this.name=name2;
   	    this.collegeid=collegeid2;
	}
	 public int getId() {
		 return id;
	 }
	 public void setId(int id) {
		this.id=id;
	 }
	 public String getName() {
		 return name;
	 }
	 public void setName(String name) {
     this.name=name;
     }
	 public int getCollegeid() {
		 return collegeid;
	 }
	 public void setCollegeid(int cid) {
		this.collegeid=cid;
	 }
	 
     
}
