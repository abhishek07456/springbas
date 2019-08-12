package org.userlist.user.server;
 import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.userlist.user.model.*;

import org.userlist.user.database.*;
@Path("/bringo")
public class server {
 
	public database obj=new database();
 	 @GET
 	 @Path("/userlist")
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<usermodel> getuser() {
 		return obj.senduser();
 		
	 }
	 @GET
	 @Path("/userlist/{cid}")
	 @Produces(MediaType.APPLICATION_JSON)
		 public List<usermodel> getspecficuser(@PathParam("cid") int cid) {
	 		return obj.specficUser(cid);
	 		
		 }
 
	 @POST
	 @Path("/adduser")
     @Consumes(MediaType.APPLICATION_JSON)

     @Produces(MediaType.APPLICATION_JSON)
 		 public List<usermodel> insertuser(usermodel ob) {
	 		return obj.addUser(ob);
	 		
		 }
 		 
 	 @POST
 	 @Path("/updateuser/{cid}")
  	 @Consumes(MediaType.APPLICATION_JSON)

 	 @Produces(MediaType.APPLICATION_JSON)
 	 		 public List<usermodel> updateuser(@PathParam("cid") int cid, usermodel ob) {
 		 		return obj.updateUser(cid,ob);
 		 		
 			 }
 }

