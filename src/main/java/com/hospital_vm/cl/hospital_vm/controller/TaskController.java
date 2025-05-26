package com.hospital_vm.cl.hospital_vm.controller; // IMPORTANTE: Asegúrate que esta línea coincida con la ruta real de tu paquete 'controller'

import com.hospital_vm.cl.hospital_vm.model.Task; // Importa tu clase Task. ¡VERIFICA LA RUTA!
import com.hospital_vm.cl.hospital_vm.service.TaskService; // Importa tu TaskService. ¡VERIFICA LA RUTA!
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // Importa todas las anotaciones de Web

import java.util.List;
import java.util.Optional;

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/api/tasks") // Todas las rutas en este controlador comenzarán con /api/tasks
public class TaskController {

    private final TaskService taskService; // Declaración para usar el servicio de tareas

    @Autowired // Spring inyectará automáticamente una instancia de TaskService aquí
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Endpoint para obtener todas las tareas (GET /api/tasks)
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Endpoint para obtener una tarea por ID (GET /api/tasks/{id})
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok) // Si la tarea existe, devuelve 200 OK con la tarea
                   .orElseGet(() -> ResponseEntity.notFound().build()); // Si no, devuelve 404 Not Found
    }

    // Endpoint para crear una nueva tarea (POST /api/tasks)
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task savedTask = taskService.saveTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED); // Devuelve 201 Created con la nueva tarea
    }

    // Endpoint para actualizar una tarea existente (PUT /api/tasks/{id})
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        Optional<Task> taskOptional = taskService.getTaskById(id);

        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setDescription(taskDetails.getDescription()); // Actualiza la descripción
            task.setCompleted(taskDetails.isCompleted());     // Actualiza el estado de completado
            Task updatedTask = taskService.saveTask(task);
            return ResponseEntity.ok(updatedTask); // Devuelve 200 OK con la tarea actualizada
        } else {
            return ResponseEntity.notFound().build(); // Si no encuentra la tarea, devuelve 404 Not Found
        }
    }

    // Endpoint para eliminar una tarea (DELETE /api/tasks/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        if (taskService.getTaskById(id).isPresent()) {
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build(); // Devuelve 204 No Content si se elimina con éxito
        } else {
            return ResponseEntity.notFound().build(); // Devuelve 404 Not Found si la tarea no existe
        }
    }
}