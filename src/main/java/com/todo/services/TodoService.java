package com.todo.services;

import com.todo.models.Todo;
import com.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public List<Todo> getAll() {
        return this.todoRepository.findAll();
    }

    public Todo create(Todo todo) {
        return this.todoRepository.insert(todo);
    }

    public Todo get(String id) {
        return this.todoRepository.findById(id).get();
    }
}
