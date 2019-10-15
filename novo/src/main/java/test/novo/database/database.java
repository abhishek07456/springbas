package test.novo.database;

import java.awt.List;
import java.util.ArrayList;

import org.bson.Document;
import org.springframework.stereotype.Controller;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import test.novo.model.SIGNUP; 


@Controller
public class database {
	         MongoDatabase database;
   		     

	         public database() {
	        	 MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
                 MongoCredential credential; 
	             credential = MongoCredential.createCredential("sampleUser", "myDb", 
	                "password".toCharArray()); 
	             System.out.println("Connected to the database successfully");  
	             database = mongo.getDatabase("novo"); 
	     	      
	         }
	         
	         public int getUniqueId() {
	        	    int id=1;
			        MongoCollection<Document> collection = database.getCollection("user"); 
			        FindIterable <Document> obj = collection.find().sort(new BasicDBObject("emp_id",-1)).limit(1);
			        for(Document row:obj)
		             {
		            	id =row.getInteger("emp_id")+1;
		             }
			        return id;

	         }
	         public void signup(SIGNUP obj){
				        MongoCollection<Document> collection = database.getCollection("user"); 
				        Document document = new Document("email", obj.getEmail()) 
					    	  .append("phone_no", obj.getPhoneNo())
					    	  .append("user_type", obj.getUserAccess())
					    	  .append("emp_id", obj.getEmpId())

                              .append("first_name", obj.getFirstName())
				    	      .append("last_name", obj.getLastName())
				    	      .append("password", obj.getPassword())
				    	      .append("middle_name", obj.getMiddleName());
				        collection.insertOne(document); 
				       
	  	 	   }
		
}
