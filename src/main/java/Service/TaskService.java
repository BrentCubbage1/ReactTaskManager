package Service;

import Repository.TaskRepository;
import Task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;




    public Task create(Task task){
        taskRepository.save(task);

        return task;
    }

    public Task read(Long id){
        return taskRepository.findById(id).isPresent() ? taskRepository.findById(id).get() : null;
    }

    public List<Task> readAll(){
//        Iterable<Task> taskList = taskRepository.findAll();
//        List<Task> result = new ArrayList<>();
//        taskList.forEach(result::add);
        return (List<Task>) taskRepository.findAll();
    }

    public Task update(Long id, String description){
        Optional<Task> maybeTask = taskRepository.findById(id);
        Task updateTask;
        if(maybeTask.isPresent()){
            updateTask = maybeTask.get();
            updateTask.setDescription(description);
            taskRepository.save(updateTask);
        } else {
            return null;
        }
        return updateTask;
    }

    public Task delete(Long id){
        Task deletedTask = read(id);
        taskRepository.delete(deletedTask);
        return deletedTask;
    }


}
