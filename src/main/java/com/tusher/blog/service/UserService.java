package com.tusher.blog.service;

import com.mongodb.MongoClient;
import com.tusher.blog.model.Blog;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.List;

public class UserService {
    MongoClient client = new MongoClient("localhost", 27017);

    Datastore datastore = new Morphia().createDatastore(client, "blog");

    public String addPost(Blog blog){
        datastore.save(blog);
        return "addPost";
    }
    public List<Blog> getAllPosts(){
        List<Blog> list = datastore.find(Blog.class).asList();
        if(list != null){
            return list;
        }else {
            return null;
        }
    }

    public Blog getPostByOtherName (String otherName){
        Blog blog = datastore.find(Blog.class, "oth", otherName).get();
        if (blog != null){
            return blog;
        }else {
            return null;
        }
    }
}
