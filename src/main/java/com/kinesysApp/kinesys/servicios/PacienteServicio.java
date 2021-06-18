package com.kinesysApp.kinesys.servicios;

import com.kinesysApp.kinesys.entidades.Paciente;
import com.kinesysApp.kinesys.entidades.Usuario;
import com.kinesysApp.kinesys.repositorios.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PacienteServicio  {

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Transactional(rollbackFor = Exception.class)
    public void crear(Long dni, String nombre, String apellido,
                      Integer telefono, String email,
                      String nombreU,String clave) {

        Paciente paciente = new Paciente();
        paciente.setDni(dni);
        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setTelefono(telefono);
        paciente.setEmail(email);
        paciente.setUsuarioPaciente(usuarioServicio.crear(nombreU,clave));
        pacienteRepositorio.save(paciente);
    }
    @Transactional(readOnly = true)
    public List<Paciente> buscarTodos() {
        return pacienteRepositorio.findAll();
    }

    @Transactional
    public void eliminar(String idPaciente) {
        pacienteRepositorio.deleteById(idPaciente);
    }

    @Transactional
    public void modificar(String idPaciente, Long dni, String nombre,
                          String apellido, Integer telefono, String email
                          ) {

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

    @Transactional(readOnly = true)
    public Paciente buscarPorId(String idPaciente) {

        return pacienteRepositorio.findById(idPaciente).orElse(null);
    }



}
