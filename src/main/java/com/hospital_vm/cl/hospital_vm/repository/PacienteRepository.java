package com.hospital_vm.cl.hospital_vm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital_vm.cl.hospital_vm.model.Paciente;
import java.util.List;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    List<Paciente> findByApellidos(String apellidos);

    Paciente findByCorreo(String correo);

    List<Paciente> findByNombresAndApellidos(String nombres, String apellidos);

    Paciente findById(Integer id);
}
