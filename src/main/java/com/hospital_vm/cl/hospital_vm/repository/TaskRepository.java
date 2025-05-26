package com.hospital_vm.cl.hospital_vm.repository; 

import com.hospital_vm.cl.hospital_vm.model.Task; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface TaskRepository extends JpaRepository<Task, Long> {
    
}