package com.kinesysApp.kinesys.servicios;

import com.kinesysApp.kinesys.entidades.Paciente;
import com.kinesysApp.kinesys.repositorios.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServicio {

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    public void crear(Long dni, String nombre, String apellido, Integer telefono, String email) {

        Paciente paciente = new Paciente();
        paciente.setDni(dni);
        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setTelefono(telefono);
        paciente.setEmail(email);
        pacienteRepositorio.save(paciente);
    }

    public List<Paciente> buscarTodos() {
        return pacienteRepositorio.findAll();
    }

    public void eliminar(String idPaciente) {
        pacienteRepositorio.deleteById(idPaciente);
    }

    public void modificar(String idPaciente, Long dni, String nombre, String apellido, Integer telefono, String email) {

        Paciente paciente = pacienteRepositorio.findById(idPaciente).orElse(null);
        if (paciente != null) {
            paciente.setDni(dni);
            paciente.setNombre(nombre);
            paciente.setApellido(apellido);
            paciente.setTelefono(telefono);
            paciente.setEmail(email);
            pacienteRepositorio.save(paciente);
        }
    }

    public Paciente buscarPorId(String idPaciente) {
        return pacienteRepositorio.findById(idPaciente).orElse(null);
    }
}
