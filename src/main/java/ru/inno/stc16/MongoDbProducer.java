package ru.inno.stc16;

import com.google.gson.Gson;
import com.mongodb.client.*;
import org.bson.Document;
import ru.inno.stc16.entity.Course;

import java.util.LinkedList;
import java.util.List;

public class MongoDbProducer {
    private MongoClient client;
    private MongoDatabase database;

    public void init() {
        client = MongoClients.create("mongodb://localhost:27017");
        database = client.getDatabase("STC-16");
    }

    public void close() {
        client.close();
    }

    public void addCourse(Course course) {
        MongoCollection collection = database.getCollection("Course");
        Document document = new Document();
        document.put("id", course.getId());
        document.put("title", course.getTitle());
        collection.insertOne(document);
    }

    public List<Course> getCourses() {
        List<Course> result = new LinkedList<>();
        MongoCollection collection = database.getCollection("Course");
        MongoCursor cursor = collection.find().iterator();
        while (cursor.hasNext()) {
            Document document = (Document) cursor.next();
            Course course = new Course();
            course.setId((Integer) document.get("id"));
            course.setTitle((String) document.get("title"));
            result.add(course);
        }
        return result;
    }

    public void addObject(Object object, String collectionName) {
        MongoCollection collection = database.getCollection(collectionName);
        Document document = Document.parse(new Gson().toJson(object));
        collection.insertOne(document);
    }

    public List<Object> getObjectList(String collectionName, Class<?> objectClass) {
        List<Object> result = new LinkedList<>();
        MongoCollection collection = database.getCollection(collectionName);
        MongoCursor cursor = collection.find().iterator();
        while (cursor.hasNext()) {
            Document document = (Document) cursor.next();
            Object object = new Gson().fromJson(document.toJson(), objectClass);
            result.add(object);
        }
        return result;
    }
}
