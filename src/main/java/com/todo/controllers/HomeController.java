package com.todo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(path = "/")
    public ResponseEntity<?> get() {
        return new ResponseEntity<>("<a href=\"/todo\">/todo</a>" +
                "<br/>" +
                "<a href=\"/todo/5ac4e171b7e1177e287a6290\">/todo/5ac4e171b7e1177e287a6290</a>" +
                "<p>/todo (post)</p>",
                HttpStatus.OK);
    }
}
