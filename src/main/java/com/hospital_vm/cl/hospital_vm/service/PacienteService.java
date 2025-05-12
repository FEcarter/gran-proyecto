package com.hospital_vm.cl.hospital_vm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital_vm.cl.hospital_vm.repository.PacienteRepository;
import com.hospital_vm.cl.hospital_vm.model.Paciente;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> findAll(){
        return pacienteRepository.findAll();
    }

    public Paciente findById(long id){
        return pacienteRepository.getById(id);
    }

    public Paciente save(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public void delete(Long id){
        pacienteRepository.deleteById(id);
    }

    public Paciente patchPaciente(Long id, Paciente parcialPaciente){
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
        if (pacienteOptional.isPresent()) {
            
            Paciente pacienteToUpdate = pacienteOptional.get();
            
            if (parcialPaciente.getNombres() != null) {
                pacienteToUpdate.setNombres(parcialPaciente.getNombres());   
            }

            if(parcialPaciente.getApellidos() != null) {
                pacienteToUpdate.setApellidos(parcialPaciente.getApellidos());
            }

            if(parcialPaciente.getCorreo() != null) {
                pacienteToUpdate.setCorreo(parcialPaciente.getCorreo());
            }

            if(parcialPaciente.getFechaNacimiento() != null) {
                pacienteToUpdate.setFechaNacimiento(parcialPaciente.getFechaNacimiento());
            }

            return pacienteRepository.save(pacienteToUpdate);
        } else {
            return null; // or throw an exception
        }
    }
}
