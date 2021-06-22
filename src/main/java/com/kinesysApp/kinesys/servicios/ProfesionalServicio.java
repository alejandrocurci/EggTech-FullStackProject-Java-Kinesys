package com.kinesysApp.kinesys.servicios;

import com.kinesysApp.kinesys.entidades.ObraSocial;
import com.kinesysApp.kinesys.entidades.Paciente;
import com.kinesysApp.kinesys.entidades.Profesional;
import com.kinesysApp.kinesys.entidades.Zona;
import com.kinesysApp.kinesys.enumeraciones.Provincia;
import com.kinesysApp.kinesys.enumeraciones.Sexo;
import com.kinesysApp.kinesys.excepciones.ExcepcionKinessysProfesional;
import com.kinesysApp.kinesys.excepciones.ExcepcionKinesysPaciente;
import com.kinesysApp.kinesys.repositorios.ProfesionalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.management.OperatingSystemMXBean;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    @Transactional(rollbackFor = Exception.class)
    public void crear(Long dni, String nombre, String apellido, Integer edad,
                      Long telefono, String email, Integer matricula, Sexo sexo,
                      Provincia provincia, String localidad, String domicilio,
                      ObraSocial obraSocial,String nombreU, String clave) {

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
        profesional.setUsuarioProfesional(usuarioServicio.crear(nombreU,clave));
        // inicia con una sola zona, luego podra agregar mas zonas
        profesional.setZonaProfesionales(Arrays.asList(zonaServicio.crear(provincia,localidad,domicilio)));

        obraSocialServicio.crear(obraSocial);

        profesional.setObraSocialProfesionales(null);

        profesionalRepositorio.save(profesional);
    }
    @Transactional(readOnly = true)
    public List<Profesional> buscarTodos() {
        return profesionalRepositorio.findAll();
    }

    @Transactional
    public void eliminarProfesional(String idProfesional) {
        profesionalRepositorio.deleteById(idProfesional);
    }


    @Transactional(readOnly = true)
    public Profesional buscarPorId(String idProfesional) {
        return profesionalRepositorio.findById(idProfesional).orElse(null);
    }

    public void validarProfesional(Long dni, String nombre, String apellido, Integer edad,
                                   Long telefono, String email, Integer matricula, Sexo sexo,
                                   Provincia provincia, String localidad, String domicilio,
                                   ObraSocial obraSocial,String nombreU, String clave) throws ExcepcionKinessysProfesional {
        if(dni == null || dni <= 0){
            throw new ExcepcionKinessysProfesional("El dni no puede ser nulo");
        }
        if(dni == null || dni <= 0){
            throw new ExcepcionKinessysProfesional("El dni no puede ser nulo");
        }
        if(nombre == null || nombre.isEmpty()){
            throw new ExcepcionKinessysProfesional("El nombre no puede ser nulo");
        }
        if(dni == null || dni <= 0){
            throw new ExcepcionKinessysProfesional("El dni no puede ser nulo");
        }
        if(dni == null || dni <= 0){
            throw new ExcepcionKinessysProfesional("El dni no puede ser nulo");
        }
        if(dni == null || dni <= 0){
            throw new ExcepcionKinessysProfesional("El dni no puede ser nulo");
        }
    }
}
