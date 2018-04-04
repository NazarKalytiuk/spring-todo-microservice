package com.todo.controllers;

import com.todo.models.Todo;
import com.todo.repositories.TodoRepository;
import com.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping(path = "/todo", produces = "application/json")
    public ResponseEntity<?> getAll() {
        try {
            List<Todo> todos = this.todoService.getAll();
            return new ResponseEntity<>(todos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/todo/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        try {
            Todo todo = this.todoService.get(id);
            return new ResponseEntity<Todo>(todo, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/todo", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> post(@RequestBody Todo todo) {
        try {
            Todo createdTodo =  this.todoService.create(todo);
            return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
