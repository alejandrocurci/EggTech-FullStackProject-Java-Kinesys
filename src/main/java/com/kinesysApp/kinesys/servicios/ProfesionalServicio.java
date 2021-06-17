package com.kinesysApp.kinesys.servicios;

import com.kinesysApp.kinesys.entidades.ObraSocial;
import com.kinesysApp.kinesys.entidades.Profesional;
import com.kinesysApp.kinesys.entidades.Zona;
import com.kinesysApp.kinesys.enumeraciones.Provincia;
import com.kinesysApp.kinesys.enumeraciones.Sexo;
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

    @Transactional(rollbackFor = Exception.class)
    public void crear(Long dni, String nombre, String apellido, Integer edad,
                      Long telefono, String email, Integer matricula, Sexo sexo,
                      Provincia provincia, String localidad, String domicilio,
                      List<ObraSocial> listObraSocial) {

        Profesional profesional = new Profesional();
        profesional.setDni(dni);
        profesional.setNombre(nombre);
        profesional.setApellido(apellido);
        profesional.setEdad(edad);
        profesional.setTelefono(telefono);
        profesional.setEmail(email);
        profesional.setMatricula(matricula);
        profesional.setSexo(sexo);

        Zona zona = new Zona();
        zona.setProvincia(provincia);
        zona.setLocalidad(localidad);
        zona.setDomicilio(domicilio);

        // inicia con una sola zona, luego podra agregar mas zonas
        profesional.setZonasProf(Arrays.asList(zona));

        profesional.setListObraSocial(listObraSocial);

        profesionalRepositorio.save(profesional);
    }
    @Transactional(readOnly = true)
    public List<Profesional> buscarTodos() {
        return profesionalRepositorio.findAll();
    }

    @Transactional
    public void eliminar(String idProfesional) {
        profesionalRepositorio.deleteById(idProfesional);
    }

    /*
    public void modificar(String idZona, String provincia, String localidad, String domicilio) {
        Zona zona = profesionalRepositorio.findById(idZona).orElse(null);
        if (zona != null) {
            zona.setProvincia(provincia);
            zona.setLocalidad(localidad);
            zona.setDomicilio(domicilio);
            profesionalRepositorio.save(zona);
        }
    }
    */

    @Transactional(readOnly = true)
    public Profesional buscarPorId(String idProfesional) {
        return profesionalRepositorio.findById(idProfesional).orElse(null);
    }
}
