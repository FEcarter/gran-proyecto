package com.hospital_vm.cl.hospital_vm.model; 

import jakarta.persistence.Entity; // Importa la anotación Entity de JPA
import jakarta.persistence.GeneratedValue; // Importa la anotación GeneratedValue de JPA
import jakarta.persistence.GenerationType; // Importa la estrategia de generación de valores
import jakarta.persistence.Id; // Importa la anotación Id de JPA
import lombok.Data; // Importa Lombok para generar automáticamente métodos comunes

@Entity // Anotación para indicar que esta clase es una entidad JPA
@Data   // Lombok generará automáticamente los métodos getter, setter, toString, equals y hashCode
public class Task {

    @Id // Anotación para indicar que este campo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotación para indicar que el valor de este campo se generará automáticamente
    private Long id; // Clave primaria de tipo Long

    private String description; // Descripción de la tarea
    private boolean completed; // Estado de la tarea (completada o no)
    
    public Task() {
    } // Constructor por defecto necesario para JPA

    
    public Task(String description, boolean completed) {
        this.description = description;
        this.completed = completed;
    } // Constructor con parámetros para facilitar la creación de instancias de Task
}
