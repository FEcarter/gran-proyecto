package com.hospital_vm.cl.hospital_vm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.hospital_vm.cl.hospital_vm.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{

    List<Medico> findByEspecialidad(String especialidad);

}
