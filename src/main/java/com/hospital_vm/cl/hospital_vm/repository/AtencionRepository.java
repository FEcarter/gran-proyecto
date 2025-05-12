package com.hospital_vm.cl.hospital_vm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hospital_vm.cl.hospital_vm.model.Atencion;
import java.util.List;

@Repository
public interface AtencionRepository extends JpaRepository<Atencion, Long> {

    @Query(""" 
        SELECT a, a.paciente.nombres, a.medico.nombreCompleto FROM Atencion a
        """)
    List<Object[]> findAtencionesConPacienteYMedico();

    List<Atencion> findByPacienteId(Long pacienteId);
    List<Atencion> findByMedicoId(Long medicoId);

}
