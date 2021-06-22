package com.kinesysApp.kinesys.servicios;

import com.kinesysApp.kinesys.entidades.Paciente;
import com.kinesysApp.kinesys.excepciones.ExcepcionKinesysPaciente;
import com.kinesysApp.kinesys.repositorios.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServicio  {

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private RolServicio rolServicio;

    @Transactional(rollbackFor = Exception.class)
    public void crear(Long dni, String nombre, String apellido,
                      String  telefono, String email,
                      String nombreU,String clave) throws ExcepcionKinesysPaciente {

        validarPaciente(dni,nombre,apellido,telefono,email,nombreU,clave);

        Paciente paciente = new Paciente();
        paciente.setRolPaciente(rolServicio.buscarPorNombre("PACIENTE"));
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
                          String apellido, String telefono, String email
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

    @Transactional
    public void elimiarPaciente(String idPaciente)throws ExcepcionKinesysPaciente{
        Optional<Paciente> respPaciente =pacienteRepositorio.findById(idPaciente);
        if(respPaciente.isPresent()){
            pacienteRepositorio.delete(respPaciente.get());
        }else{
            throw new ExcepcionKinesysPaciente("El paciente no puede ser eliminado");
        }

    }
    @Transactional(readOnly = true)
    public Paciente buscarPacientePorDni(Long dni) throws ExcepcionKinesysPaciente {

        Paciente respPaciente =pacienteRepositorio.BuscarPorDni(dni);
        if (respPaciente== null) {
            throw new ExcepcionKinesysPaciente("No existe ese paciente registrado");
        } else {
            return respPaciente;
        }
    }

    public void validarPaciente(Long dni, String nombre, String apellido, String telefono, String email,
                                String nombreU,String clave) throws ExcepcionKinesysPaciente {
        if(dni == null || dni <= 0){
            throw new ExcepcionKinesysPaciente("El dni no puede ser nulo");
        }
        if(dni == null || dni <= 0){
            throw new ExcepcionKinesysPaciente("El dni no puede ser nulo");
        }
        Paciente paciente = pacienteRepositorio.BuscarPorDni(dni);
        if(paciente != null ){
            throw new ExcepcionKinesysPaciente("El paciente se encuentra registrado con ese dni");
        }
        if(nombre == null || nombre.isEmpty()){
            throw new ExcepcionKinesysPaciente("El nombre no puede ser nulo");
        }
        if(apellido == null || apellido.isEmpty()){
            throw new ExcepcionKinesysPaciente("El apellido no puede ser nulo");
        }
        if(telefono == null || dni <= 0){
            throw new ExcepcionKinesysPaciente("El telefono no puede ser nulo");
        }
        if(email == null || email.isEmpty()){
            throw new ExcepcionKinesysPaciente("El email no puede ser nulo");
        }
    }


}
