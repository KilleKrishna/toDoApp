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
        if (todoid >= todos.size())
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        JSONObject jsonResponse = new JSONObject()
                .put("todoname", todos.get(todoid))
                .put("status", "Todo " + (todoid + 1) + " retrieved")
                .put("timestamp", Instant.now().toString());
        return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
    }

    public ResponseEntity<?> addTodo(String json) throws JSONException {
        JSONObject obj = new JSONObject(json);
        String todoname = obj.getString("todoname");
        todos.add(todoname);
        return sendResponse("Todo " + todoname + " Added");
    }

    public ResponseEntity<?> updateTodo(int todoid, String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        if (todoid >= todos.size())
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        String todoname = jsonObject.getString("todoname");
        todos.set(todoid, todoname);
        return sendResponse("Todo-" + (todoid + 1) + " Updated");
    }

    public ResponseEntity<?> deleteTodo(int todoid) throws JSONException {
        if (todoid >= todos.size())
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        todos.remove(todoid);
        return sendResponse("Todo-" + (todoid + 1) + " Deleted");
    }

    private ResponseEntity<?> sendResponse(String status) throws JSONException {
        JSONObject jsonResponse = new JSONObject()
                .put("todos", todos)
                .put("status", status)
                .put("timestamp", Instant.now().toString());
        return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
    }
}