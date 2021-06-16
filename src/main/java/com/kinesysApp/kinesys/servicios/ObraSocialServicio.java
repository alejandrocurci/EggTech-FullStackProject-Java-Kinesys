package com.kinesysApp.kinesys.servicios;

import com.kinesysApp.kinesys.entidades.ObraSocial;
import com.kinesysApp.kinesys.repositorios.ObraSocialRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ObraSocialServicio {

    @Autowired
    private ObraSocialRepositorio obraSocialRepositorio;

    @Transactional(rollbackFor = Exception.class)
    public void crear(String nombre, Long telefono, String email) {

        ObraSocial obraSocial = new ObraSocial();

        obraSocial.setEmail(email);
        obraSocial.setTelefono(telefono);
        obraSocial.setNombre(nombre);
        obraSocial.setListaProfesionales(new ArrayList<>()); // se inicia la lista vacia para luego agregar los profesionales
        obraSocialRepositorio.save(obraSocial);
    }
    @Transactional(readOnly = true)
    public List<ObraSocial> buscarTodas() {

        return obraSocialRepositorio.findAll();
    }

    public void eliminar(String idObraSocial) {

        obraSocialRepositorio.deleteById(idObraSocial);
    }

    public void modificar(String idObraSocial, String nombre, Long telefono, String email) {

        ObraSocial obraSocial = obraSocialRepositorio.findById(idObraSocial).orElse(null);
        if (obraSocial != null) {
            obraSocial.setEmail(email);
            obraSocial.setTelefono(telefono);
            obraSocial.setNombre(nombre);
            //obraSocial.setListaProfesionales(new ArrayList<>()); // se inicia la lista vacia para luego agregar los profesionales
            obraSocialRepositorio.save(obraSocial);
        }
    }
    @Transactional(readOnly = true)
    public ObraSocial buscarPorId(String idObraSocial) {

        return obraSocialRepositorio.findById(idObraSocial).orElse(null);
    }
}
