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
	 
	public   List <usermodel> addUser(usermodel obj){
		     List <usermodel> ul=new ArrayList <>();
                   usermodel user=new usermodel(obj.getId(),obj.getName(),obj.getCollegeid());
                   ul.add(user);
			        MongoCollection<Document> collection = database.getCollection("userlist"); 
			        Document document = new Document("id", obj.getId()) 
			    	      .append("name", obj.getName())
			    	      .append("collegeid", obj.getCollegeid());
			        collection.insertOne(document); 
			        return ul;
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
  	   
  	   public List <usermodel> updateUser(int collid,usermodel obj)
  	   {
  		 List <usermodel> ul=new ArrayList <>();
         usermodel user=new usermodel(obj.getId(),obj.getName(),obj.getCollegeid());
         ul.add(user);
  		 Document set=new Document();
  		 set.append("collegeid",collid);
  		Document document = new Document("id", obj.getId()) 
	    	      .append("name", obj.getName())
	    	      .append("collegeid", obj.getCollegeid());
  		 Document update=new Document("$set",document);
         
  		 MongoCollection <Document> collection = database.getCollection("userlist"); 
  		 collection.updateOne(set,update);
  	     return ul;
	     
         
  	   }
	 
	

}
