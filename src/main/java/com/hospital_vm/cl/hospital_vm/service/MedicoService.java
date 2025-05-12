package com.hospital_vm.cl.hospital_vm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import com.hospital_vm.cl.hospital_vm.repository.MedicoRepository;
import com.hospital_vm.cl.hospital_vm.model.Medico;
import java.util.List;


@Service
@Transactional
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> findAll(){
        return medicoRepository.findAll();
    }

    public Medico save(Medico medico){
        return medicoRepository.save(medico);
    }

    public void delete(Long id){
        medicoRepository.deleteById(id);
    }
    
    public Medico updateMedico(Long id, Medico medico){
        Medico medicoToUpdate = medicoRepository.findById(id).orElse(null);
        if (medicoToUpdate != null) {
            medicoToUpdate.setNombreCompleto(medico.getNombreCompleto());
            medicoToUpdate.setJefeTurno(medico.getJefeTurno());
            return medicoRepository.save(medicoToUpdate);
        } else {
            return null;
        }
    }

    public Medico patchMedico(Long id, Medico parcialMedico){
        Medico medicoToUpdate = medicoRepository.findById(id).orElse(null);
        if (medicoToUpdate != null) {
            if (parcialMedico.getNombreCompleto() != null) {
                medicoToUpdate.setNombreCompleto(parcialMedico.getNombreCompleto());
            }
            if (parcialMedico.getJefeTurno() != null) {
                medicoToUpdate.setJefeTurno(parcialMedico.getJefeTurno());
            }
            return medicoRepository.save(medicoToUpdate);
        } else {
            return null;
        }
    }

    public Medico findById(long id){
        return medicoRepository.getById(id);
    }

    public List<Medico> findByEspecialidad(String especialidad){
        return medicoRepository.findByEspecialidad(especialidad);
    }

}
