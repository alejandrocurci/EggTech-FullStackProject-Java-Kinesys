package com.kinesysApp.kinesys.servicios;

import com.kinesysApp.kinesys.entidades.Paciente;
import com.kinesysApp.kinesys.excepciones.ExcepcionKinesysPaciente;
import com.kinesysApp.kinesys.repositorios.PacienteRepositorio;
import com.kinesysApp.kinesys.roles.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServicio {

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private RolServicio rolServicio;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    public void crear(Long dni, String nombre, String apellido,
                      String telefono, String email,
                      String nombreU, String clave) throws ExcepcionKinesysPaciente {

        validarPaciente(dni, nombre, apellido, telefono, email, nombreU, clave);

        Paciente paciente = new Paciente();
        String rolnombre = "PACIENTE";
        Rol rol=rolServicio.buscarPorNombre(rolnombre);
        paciente.setRolPaciente(rol);
        paciente.setDni(dni);
        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setTelefono(telefono);
        paciente.setEmail(email);
        paciente.setUsuarioPaciente(usuarioServicio.crear(nombreU, clave,rol));
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
                          String apellido, String telefono, String email) throws ExcepcionKinesysPaciente{

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
    public void eliminarPaciente(String idPaciente) throws ExcepcionKinesysPaciente {
        Optional<Paciente> respPaciente = pacienteRepositorio.findById(idPaciente);
        if (respPaciente.isPresent()) {
            pacienteRepositorio.delete(respPaciente.get());
        } else {
            throw new ExcepcionKinesysPaciente("El paciente no puede ser eliminado");
        }

    }

    @Transactional(readOnly = true)
    public List<Paciente> buscarPacientePorDni(Long dni) throws ExcepcionKinesysPaciente {
        List<Paciente> respPaciente = null;
        if (dni == null) {
            respPaciente = pacienteRepositorio.findAll();
        } else {
            respPaciente = Arrays.asList(pacienteRepositorio.findByDni(dni));
            if (respPaciente == null) {
                throw new ExcepcionKinesysPaciente("No existe ese paciente registrado");
            }
        }
        return respPaciente;
    }

    @Transactional(readOnly = true)
    public List<Paciente> buscarPacientePorNombre(String nombre) throws ExcepcionKinesysPaciente {

        List<Paciente> respPaciente = null;
        if (nombre.isEmpty()) {
            respPaciente = pacienteRepositorio.findAll();
        } else {
            respPaciente = pacienteRepositorio.findByNombre(nombre);
            if (respPaciente == null || respPaciente.isEmpty()) {
                throw new ExcepcionKinesysPaciente("No existe ese paciente registrado");
            }
        }
        return respPaciente;
    }


    public void validarPaciente(Long dni, String nombre, String apellido, String telefono, String email,
                                String nombreU, String clave) throws ExcepcionKinesysPaciente {
        if (dni == null || dni <= 0) {
            throw new ExcepcionKinesysPaciente("El dni no puede ser nulo");
        }
        if (dni == null || dni <= 0) {
            throw new ExcepcionKinesysPaciente("El dni no puede ser nulo");
        }
        Paciente paciente = pacienteRepositorio.findByDni(dni);
        if (paciente != null) {
            throw new ExcepcionKinesysPaciente("El paciente se encuentra registrado con ese dni");
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new ExcepcionKinesysPaciente("El nombre no puede ser nulo");
        }
        if (apellido == null || apellido.isEmpty()) {
            throw new ExcepcionKinesysPaciente("El apellido no puede ser nulo");
        }
        if (telefono == null || dni <= 0) {
            throw new ExcepcionKinesysPaciente("El telefono no puede ser nulo");
        }
        if (email == null || email.isEmpty()) {
            throw new ExcepcionKinesysPaciente("El email no puede ser nulo");
        }
    }

    // FUNCIONALIDAD PARA PERFIL

    @Transactional
    public void actualizarNombre(String idPaciente, String nombreNuevo) {
        Paciente paciente = pacienteRepositorio.findById(idPaciente).orElse(null);
        paciente.setNombre(nombreNuevo);
        pacienteRepositorio.save(paciente);
    }

    @Transactional
    public void actualizarApellido(String idPaciente, String apellidoNuevo) {
        Paciente paciente = pacienteRepositorio.findById(idPaciente).orElse(null);
        paciente.setApellido(apellidoNuevo);
        pacienteRepositorio.save(paciente);
    }

    @Transactional
    public void actualizarDni(String idPaciente, Long dniNuevo) {
        Paciente paciente = pacienteRepositorio.findById(idPaciente).orElse(null);
        paciente.setDni(dniNuevo);
        pacienteRepositorio.save(paciente);
    }

    @Transactional
    public void actualizarTelefono(String idPaciente, String telefonoNuevo) {
        Paciente paciente = pacienteRepositorio.findById(idPaciente).orElse(null);
        paciente.setTelefono(telefonoNuevo);
        pacienteRepositorio.save(paciente);
    }

    @Transactional
    public void actualizarEmail(String idPaciente, String emailNuevo) {
        Paciente paciente = pacienteRepositorio.findById(idPaciente).orElse(null);
        paciente.setEmail(emailNuevo);
        pacienteRepositorio.save(paciente);
    }

    @Transactional
    public void actualizarUsuario(String idPaciente, String usuarioNuevo) {
        Paciente paciente = pacienteRepositorio.findById(idPaciente).orElse(null);
        paciente.getUsuarioPaciente().setNombreU(usuarioNuevo);
        pacienteRepositorio.save(paciente);
    }

    @Transactional
    public void actualizarClave(String idPaciente, String claveNueva) {
        Paciente paciente = pacienteRepositorio.findById(idPaciente).orElse(null);
        paciente.getUsuarioPaciente().setClave(encoder.encode(claveNueva));
        pacienteRepositorio.save(paciente);
    }


}
