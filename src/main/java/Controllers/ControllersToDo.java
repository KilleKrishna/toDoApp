package Controllers;

import Services.ServicesToDo;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int todoid, @RequestBody String json) throws JSONException {
        return servicesToDo.updateTodo(todoid, json);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable("id") int todoid) throws JSONException {
        return servicesToDo.deleteTodo(todoid);
    }
}
