package com.hospital_vm.cl.hospital_vm.model; 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data; 

@Entity
@Data   
public class Task {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 

    private String description; 
    private boolean completed; 

    
    public Task() {
    }

    
    public Task(String description, boolean completed) {
        this.description = description;
        this.completed = completed;
    }
}
