package com.todo.models;
import org.springframework.data.annotation.Id;
public class Todo {
    @Id
    public String id;
    public String name;
    public String authorId;
    // TODO: Implement checked:Boolean
}
