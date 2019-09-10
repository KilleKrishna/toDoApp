package com.tavisca.toDoApp.Services;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicesToDo {
    private List<String> todos = new ArrayList<>();

    public ResponseEntity<?> getTodos() throws JSONException {
        return sendResponse("All Todos returned");
    }

    public ResponseEntity<?> getTodoById(int todoid) throws JSONException {
        if(todoid==0)
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        if (todoid >= todos.size()+1)
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        JSONObject jsonResponse = new JSONObject()
                .put("todoname", todos.get(todoid-1))
                .put("status", "Todo " + (todoid ) + " retrieved")
                .put("timestamp", Instant.now().toString());
        return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
    }

    public ResponseEntity<?> addTodo(String json) throws JSONException {
        JSONObject obj = new JSONObject(json);
        String todoname = obj.getString("todoname");
        todos.add(todoname);
        return sendResponse("Todo " + todoname + " Added");
    }

    public ResponseEntity<?> updateTodo(String name,String newname) throws JSONException {
        int id=0;
        for(int i=0;i<todos.size();i++)
        {
            if(todos.get(i).equals(name))
            {
                id=i;
            }
        }
        todos.remove(id);
        todos.add(newname);
        return sendResponse("Todo-" + name + " Updated");
    }

    public ResponseEntity<?> deleteTodo(String name) throws JSONException {
        int id=0;
        for(int i=0;i<todos.size();i++)
        {
            if(todos.get(i).equals(name))
            {
                id=i;
            }
        }
        todos.remove(id);
        return sendResponse("Todo-" + name + " Deleted");
    }

    private ResponseEntity<?> sendResponse(String status) throws JSONException {
        JSONObject jsonResponse = new JSONObject()
                .put("todos", todos)
                .put("status", status)
                .put("timestamp", Instant.now().toString());
        return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
    }
}