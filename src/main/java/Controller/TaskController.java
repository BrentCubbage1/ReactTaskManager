package Controller;

import Service.TaskService;
import Task.Task;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {


    private TaskService taskService;




    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping(value = "/get")
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = taskService.readAll();

        return ResponseEntity.status(HttpStatus.OK).body(tasks);

    }

    @GetMapping( value = "/get/{id}")
    public ResponseEntity<Task> getTasks(@PathVariable Long id){
        Task task = taskService.read(id);
        //Needs to account for if it is not found?

        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task createdTask = taskService.create(task);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, String description){
        Task updatedTask = taskService.update(id, description);
        //Needs to account for if it is not found?
        return ResponseEntity.status(HttpStatus.OK).body(updatedTask);
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Long id){
        Task deletedTask = taskService.delete(id);
        //Needs to account for if it is not found?

        return ResponseEntity.status(HttpStatus.OK).body(deletedTask);
    }
}
