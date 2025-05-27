
package com.hospital_vm.cl.hospital_vm.service; // Service para manejar la lógica de negocio relacionada con las tareas

import com.hospital_vm.cl.hospital_vm.model.Task; // Importa mi clase Task
import com.hospital_vm.cl.hospital_vm.repository.TaskRepository;    // Importa mi TaskRepository
import org.springframework.beans.factory.annotation.Autowired;  // Importa la anotación Autowired para inyección de dependencias
import org.springframework.stereotype.Service; // Importa la anotación Service de Spring para indicar que esta clase es un servicio

import java.util.List; // Importa la clase List de Java para manejar colecciones de tareas
import java.util.Optional; // Importa la clase Optional de Java para manejar valores que pueden ser nulos

@Service // Anotación para indicar que esta clase es un servicio de Spring
public class TaskService {

    private final TaskRepository taskRepository; 

    @Autowired // Spring inyectará automáticamente una instancia de TaskRepository aquí
    // Constructor para inyectar el TaskRepository
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    } // Constructor que recibe el TaskRepository para manejar las operaciones de la base de datos
    // Métodos del servicio para manejar las tareas

    
    public List<Task> getAllTasks() {
        return taskRepository.findAll(); 
    } // Método para obtener todas las tareas de la base de datos
    // Este método utiliza el TaskRepository para recuperar todas las tareas almacenadas en la base de datos

    
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id); 
    } // Método para obtener una tarea por su ID
    // Este método utiliza el TaskRepository para buscar una tarea específica por su ID, devolviendo un Optional que puede contener la tarea o estar vacío si no se encuentra

    
    public Task saveTask(Task task) {
        return taskRepository.save(task); 
    } // Método para guardar una nueva tarea o actualizar una existente
    // Este método utiliza el TaskRepository para guardar la tarea en la base de datos, ya sea creando una nueva o actualizando una existente

    
    public void deleteTask(Long id) {
        taskRepository.deleteById(id); 
    } // Método para eliminar una tarea por su ID
    // Este método utiliza el TaskRepository para eliminar una tarea específica de la base de datos por su ID
    
} // Esta clase maneja la lógica de negocio relacionada con las tareas, como obtener todas las tareas, obtener una tarea por ID, guardar una nueva tarea y eliminar una tarea existente.
// No es necesario implementar ningún método aquí, ya que TaskRepository ya proporciona todos los métodos necesarios para manejar la entidad Task