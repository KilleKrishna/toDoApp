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
        return todoService.getTodoById(todoid);
    }



}
