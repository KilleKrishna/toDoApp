package Services;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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
}
