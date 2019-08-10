package org.userlist.user.database;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection; 
import com.mongodb.client.MongoDatabase; 

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;  
import org.userlist.user.model.*;
public class database {
	         MongoDatabase database;
	         public database() {
	        	 MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
                 MongoCredential credential; 
	             credential = MongoCredential.createCredential("sampleUser", "myDb", 
	                "password".toCharArray()); 
	             System.out.println("Connected to the database successfully");  
	             database = mongo.getDatabase("user"); 
	     	      
	         }
  	  public  List <usermodel> senduser(){
	         MongoCollection <Document> collection = database.getCollection("userlist"); 
   		     List <usermodel> ul=new ArrayList <>();
             FindIterable <Document> document=collection.find();
             
             for(Document obj:document)
             {
            	String s=obj.getString("name");
            	int id=obj.getInteger("id");
            	int cid=obj.getInteger("collegeid");
            	usermodel user=new usermodel(id,s,cid);
            	ul.add(user);

             }
                
              return ul;
 	   }
	 
	public  String adduser(){
		       MongoCollection<Document> collection = database.getCollection("userlist"); 
		       Document document = new Document("id", 1) 
		    	      .append("name", "abhishek")
		    	      .append("collegeid", 31);
		        collection.insertOne(document); 
                return "inserted succesfully";
 	 	   }
  	   public List <usermodel> specficUser(int collid)
  	   {
           System.out.println(collid);  

  		 List<DBObject> criteria = new ArrayList<DBObject>();
  		 criteria.add(new BasicDBObject("collegeid",new BasicDBObject("$eq", collid)));
  		 MongoCollection <Document> collection = database.getCollection("userlist"); 
		     List <usermodel> ul=new ArrayList <>();
         FindIterable <Document> document=collection.find(new BasicDBObject("$and",criteria));
         
         for(Document obj:document)
         {
        	String s=obj.getString("name");
        	int id=obj.getInteger("id");
        	int cid=obj.getInteger("collegeid");
        	usermodel user=new usermodel(id,s,cid);
        	ul.add(user);

         }
            
          return ul;
  		 
  		 
  	   }
	

}
