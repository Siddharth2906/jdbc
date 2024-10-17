package com.example;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;



public class App 
{
    public static void main( String[] args )
    {
      
        String uri = "mongodb://localhost:27017"; // Replace with your MongoDB URI
        String dbName = "testdb"; // Replace with your database name
        String collectionName = "testcollection"; // Replace with your collection name

        MongoDBJDBC mongoDBJDBC = new MongoDBJDBC(uri, dbName);
        MongoCollection<Document> collection = mongoDBJDBC.getCollection(collectionName);

        // Insert a document
        // Document document = new Document("name", "John Doe")
        //                         .append("age", 29)
        //                         .append("city", "New York");
        // mongoDBJDBC.insertDocument(collection, document);

        System.out.println("Documents in collection:");
        mongoDBJDBC.viewDocuments(collection);

        // // Delete a document
        // Document query = new Document("name", "John Doe");
        // mongoDBJDBC.deleteDocument(collection, query);

        // // View documents after deletion
        // System.out.println("Documents in collection after deletion:");
        // mongoDBJDBC.viewDocuments(collection);

        mongoDBJDBC.close();
    }

 
}
