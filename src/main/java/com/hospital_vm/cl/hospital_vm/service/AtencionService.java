package com.hospital_vm.cl.hospital_vm.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital_vm.cl.hospital_vm.model.Atencion;
import com.hospital_vm.cl.hospital_vm.repository.AtencionRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AtencionService {

    @Autowired
    private AtencionRepository atencionRepository;
    
    public List<Atencion> obtenerAtenciones() {
        return atencionRepository.findAll();
    }
    public Atencion obtenerAtencionPorId(Long id) {
        return atencionRepository.findById(id).orElse(null);
    }
    public Atencion guardarAtencion(Atencion atencion) {
        return atencionRepository.save(atencion);
    }
    public void eliminarAtencion(Long id) {
        atencionRepository.deleteById(id);
    }
    public Atencion actualizarAtencion(Long id, Atencion atencion) {
        Atencion atencionExistente = atencionRepository.findById(id).orElse(null);
        if (atencionExistente != null) {
            atencionExistente.setFechaAtencion(atencion.getFechaAtencion());
            atencionExistente.setHoraAtencion(atencion.getHoraAtencion());
            atencionExistente.setPaciente(atencion.getPaciente());
            atencionExistente.setMedico(atencion.getMedico());
            return atencionRepository.save(atencionExistente);
        } else {
            return null;
        }
    }
    public Atencion actualizarAtencionParcial(Long id, Atencion atencionParcial) {
        Atencion atencionExistente = atencionRepository.findById(id).orElse(null);
        if (atencionExistente != null) {
            if (atencionParcial.getFechaAtencion() != null) {
                atencionExistente.setFechaAtencion(atencionParcial.getFechaAtencion());
            }
            if (atencionParcial.getHoraAtencion() != null) {
                atencionExistente.setHoraAtencion(atencionParcial.getHoraAtencion());
            }
            if (atencionParcial.getPaciente() != null) {
                atencionExistente.setPaciente(atencionParcial.getPaciente());
            }
            if (atencionParcial.getMedico() != null) {
                atencionExistente.setMedico(atencionParcial.getMedico());
            }
            return atencionRepository.save(atencionExistente);
        } else {
            return null;
        }
    }

    public List<Map<String, Object>> obtenerAtencionesConNombres() {
        List<Object[]> resultados = atencionRepository.findAtencionesConPacienteYMedico();
        List<Map<String, Object>> lista = new ArrayList<>();

        for (Object[] fila : resultados) {
            Map<String, Object> datos = new HashMap<>();
            datos.put("atencion", fila[0]);
            datos.put("nombrePaciente", fila[1]);
            datos.put("nombreMedico", fila[2]);
            lista.add(datos);
        }

        return lista;
    }

    public List<Atencion> obtenerAtencionesPorPacienteId(Long pacienteId) {
        return atencionRepository.findByPacienteId(pacienteId);
    }
    public List<Atencion> obtenerAtencionesPorMedicoId(Long medicoId) {
        return atencionRepository.findByMedicoId(medicoId);
    }
    public List<Atencion> obtenerAtencionesPorPacienteIdYMedicoId(Long pacienteId, Long medicoId) {
        return atencionRepository.findByPacienteId(pacienteId).stream()
                .filter(atencion -> atencion.getMedico().getId().equals(medicoId))
                .collect(Collectors.toList());
    }
    public List<Atencion> obtenerAtencionesPorMedicoIdYPacienteId(Long medicoId, Long pacienteId) {
        return atencionRepository.findByMedicoId(medicoId).stream()
                .filter(atencion -> atencion.getPaciente().getId().equals(pacienteId))
                .collect(Collectors.toList());
    }

}
