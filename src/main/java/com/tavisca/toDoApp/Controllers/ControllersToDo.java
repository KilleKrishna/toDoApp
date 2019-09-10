package com.tavisca.toDoApp.Controllers;

import com.tavisca.toDoApp.Services.ServicesToDo;
import org.graalvm.compiler.lir.CompositeValue;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todos")

@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ControllersToDo {
    @Autowired
    ServicesToDo servicesToDo;
    private List<String> todos = new ArrayList<>();


    @GetMapping(path = "")
    public ResponseEntity<?> get() throws JSONException {
        return servicesToDo.getTodos();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int todoid) throws JSONException {
        return servicesToDo.getTodoById(todoid);
    }

    @PostMapping(path = "")
    public ResponseEntity<?> add(@RequestBody String json) throws JSONException {
        return servicesToDo.addTodo(json);
    }

    @PutMapping(path = "/{oldname}/{newname}")
    public ResponseEntity<?> update(@PathVariable("oldname") String oldname,@PathVariable("newname") String newname) throws JSONException {
        return servicesToDo.updateTodo(oldname,newname);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable("id") String todoid) throws JSONException {
        return servicesToDo.deleteTodo(todoid);
    }
}
