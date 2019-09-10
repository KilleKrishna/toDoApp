package Controllers;

import Services.ServicesToDo;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
