
package com.hospital_vm.cl.hospital_vm.service;

import com.hospital_vm.cl.hospital_vm.model.Task; 
import com.hospital_vm.cl.hospital_vm.repository.TaskRepository; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class TaskService {

    private final TaskRepository taskRepository; 

    @Autowired 
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    
    public List<Task> getAllTasks() {
        return taskRepository.findAll(); 
    }

    
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id); 
    }

    
    public Task saveTask(Task task) {
        return taskRepository.save(task); 
    }

    
    public void deleteTask(Long id) {
        taskRepository.deleteById(id); 
    }
}