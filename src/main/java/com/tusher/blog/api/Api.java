package com.tusher.blog.api;

import com.google.gson.Gson;
import com.tusher.blog.model.Blog;
import com.tusher.blog.service.UserService;

import static spark.Spark.post;
import static spark.Spark.get;

public class Api {

    static UserService userService = new UserService();


    public static void main(String[] args) {

        final Gson gson = new Gson();

        post("/add-post", (request, response) -> {
            response.type("application/json");
            Blog blog = gson.fromJson(request.body(), Blog.class);
            return userService.addPost(blog);
        }, gson::toJson);

        get("/", (request, response)-> {
            response.type("application/json");
            return userService.getAllPosts();
        }, gson ::toJson);

        get("/:otherName", (request, response)-> {
            response.type("application/json");
            Blog blog = userService.getPostByOtherName(request.params("otherName"));
            if (blog !=null){
                return blog;
            } else {
                return "Post not found";
            }
        }, gson ::toJson);
    }
}
