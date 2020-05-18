package com.claykab.todo_api.todo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping(TodoController.BASE_URL)
public class TodoController {
    public static final String BASE_URL="api/v1/todo";
    private static final Logger logger=Logger.getLogger(TodoController.class.getName());




}
