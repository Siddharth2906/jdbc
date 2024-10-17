package com.example;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBJDBC {
private MongoClient mongoClient;
    private MongoDatabase database;

    public MongoDBJDBC(String uri, String dbName) {
        mongoClient = new MongoClient(new MongoClientURI(uri));
        database = mongoClient.getDatabase(dbName);
    }

    public MongoCollection<Document> getCollection(String collectionName) {
        return database.getCollection(collectionName);
    }

    public void close() {
        mongoClient.close();
    }
    public void insertDocument(MongoCollection<Document> collection, Document document) {
        collection.insertOne(document);
    }
    public void viewDocuments(MongoCollection<Document> collection) {
        for (Document doc : collection.find()) {
            System.out.println(doc.toJson());
        }
    }
   
public void deleteDocument(MongoCollection<Document> collection, Document query) {
    collection.deleteOne(query);
}

}
