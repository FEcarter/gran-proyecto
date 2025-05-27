package com.hospital_vm.cl.hospital_vm.repository; // Repository para la entidad Task

import com.hospital_vm.cl.hospital_vm.model.Task; // Importa mi clase Task
import org.springframework.data.jpa.repository.JpaRepository; // Importa JpaRepository de Spring Data JPA
import org.springframework.stereotype.Repository; // Importa la anotación Repository de Spring para indicar que esta interfaz es un repositorio

@Repository // Anotación para indicar que esta interfaz es un repositorio de Spring
public interface TaskRepository extends JpaRepository<Task, Long> {
    
} // Esta interfaz hereda de JpaRepository, lo que le proporciona métodos CRUD básicos para la entidad Task 
//No es necesario implementar ningún método aquí, ya que JpaRepository ya proporciona todos los métodos necesarios para manejar la entidad Task