package com.kinesysApp.kinesys.servicios;

import com.kinesysApp.kinesys.entidades.*;
import com.kinesysApp.kinesys.enumeraciones.Sexo;
import com.kinesysApp.kinesys.excepciones.ExcepcionKinessysProfesional;
import com.kinesysApp.kinesys.excepciones.ExcepcionKinesysPaciente;
import com.kinesysApp.kinesys.repositorios.ProfesionalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class ProfesionalServicio {

    @Autowired
    private ProfesionalRepositorio profesionalRepositorio;

    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private ZonaServicio zonaServicio;
    @Autowired
    private RolServicio rolServicio;
    @Autowired
    private ObraSocialServicio obraSocialServicio;

    @Transactional
    public void crear(Long dni,
                      String nombre,
                      String apellido,
                      Integer edad,
                      Long telefono,
                      String email,
                      Integer matricula,
                      Sexo sexo,
                      Zona zona,
                      ObraSocial obraSocial,
                      Usuario usuario) throws ExcepcionKinessysProfesional {

        validarProfesional(dni, nombre, apellido, edad, telefono, email, matricula, sexo, zona, obraSocial, usuario);

        Profesional profesional = new Profesional();
        profesional.setRolProfesional(rolServicio.buscarPorNombre("PROFESIONAL"));
        profesional.setDni(dni);
        profesional.setNombre(nombre);
        profesional.setApellido(apellido);
        profesional.setEdad(edad);
        profesional.setTelefono(telefono);
        profesional.setEmail(email);
        profesional.setMatricula(matricula);
        profesional.setSexo(sexo);

        //seteamos el usuario
        profesional.setUsuarioProfesional(usuarioServicio.crear(usuario.getNombreU(), usuario.getClave()));

        profesional.setZonaProfesionales(Arrays.asList(zona));

        profesional.setObraSocialProfesionales(Arrays.asList(obraSocial));

        profesionalRepositorio.save(profesional);
    }

    @Transactional(readOnly = true)
    public List<Profesional> buscarTodos() {
        return profesionalRepositorio.findAll();
    }

    @Transactional
    public void eliminarProfesional(String idProfesional) throws ExcepcionKinessysProfesional {
        profesionalRepositorio.deleteById(idProfesional);
    }

    @Transactional(readOnly = true)
    public Profesional buscarPorId(String idProfesional) {
        return profesionalRepositorio.findById(idProfesional).orElse(null);
    }

    public void validarProfesional(Long dni,
                                   String nombre,
                                   String apellido,
                                   Integer edad,
                                   Long telefono,
                                   String email,
                                   Integer matricula,
                                   Sexo sexo,
                                   Zona zona,
                                   ObraSocial obraSocial,
                                   Usuario usuario) throws ExcepcionKinessysProfesional {

        if (dni == null || dni <= 0) {
            throw new ExcepcionKinessysProfesional("El dni no puede ser nulo");
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new ExcepcionKinessysProfesional("El nombre no puede ser nulo");
        }
        if (apellido == null || apellido.isEmpty()) {
            throw new ExcepcionKinessysProfesional("El apellido no puede ser nulo");
        }
        if (edad == null) {
            throw new ExcepcionKinessysProfesional("La edad no puede ser nula");
        }
        if (edad <= 0) {
            throw new ExcepcionKinessysProfesional("La edad debe ser mayor que 0");
        }
        if (edad >= 120) {
            throw new ExcepcionKinessysProfesional("La edad debe ser menor que 120");
        }
        if (dni == null || dni <= 0) {
            throw new ExcepcionKinessysProfesional("El dni no puede ser nulo");
        }
    }

    @Transactional
    public void modificar(String idProfesional, Long dni, String nombre, String apellido, Integer edad,
                          Long telefono, String email, Integer matricula, Sexo sexo) throws ExcepcionKinesysPaciente {
        // modificar usuario, obras sociales, zona se hacen aparte
        // obras sociales requieren agregar y eliminar de la lista
        // idem zona

        // VALIDAR PARAMETROS
        Profesional profesional = profesionalRepositorio.findById(idProfesional).orElse(null);
        if (profesional != null) {
            profesional.setDni(dni);
            profesional.setNombre(nombre);
            profesional.setApellido(apellido);
            profesional.setEdad(edad);
            profesional.setTelefono(telefono);
            profesional.setEmail(email);
            profesional.setMatricula(matricula);
            profesional.setSexo(sexo);
            profesionalRepositorio.save(profesional);
        }
    }
}
