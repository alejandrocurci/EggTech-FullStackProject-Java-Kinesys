package com.kinesysApp.kinesys.servicios;

import com.kinesysApp.kinesys.entidades.ObraSocial;
import com.kinesysApp.kinesys.entidades.Paciente;
import com.kinesysApp.kinesys.excepciones.ExcepcionKinessysObraSocial;
import com.kinesysApp.kinesys.excepciones.ExcepcionKinesysPaciente;
import com.kinesysApp.kinesys.repositorios.ObraSocialRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ObraSocialServicio {

    @Autowired
    private ObraSocialRepositorio obraSocialRepositorio;

   /* @Transactional(rollbackFor = Exception.class)
    public void crear(String nombre, Long telefono, String plan) {

        ObraSocial obraSocial = new ObraSocial();
        obraSocial.setNombre(nombre);
        obraSocial.setTelefono(telefono);
        obraSocial.setPlan(plan);
        obraSocialRepositorio.save(obraSocial);
    }*/

    @Transactional(rollbackFor = Exception.class)
    public void crear(ObraSocial obraSocia) {

        ObraSocial obraSocial = new ObraSocial();
        obraSocial.setNombre(obraSocia.getNombre());
        obraSocial.setTelefono(obraSocia.getTelefono());
        obraSocial.setPlan(obraSocia.getPlan());
        obraSocialRepositorio.save(obraSocial);

    }

    @Transactional(readOnly = true)
    public List<ObraSocial> buscarTodas() {

        return obraSocialRepositorio.findAll();
    }

    @Transactional
    public void eliminar(String idObraSocial) {

        obraSocialRepositorio.deleteById(idObraSocial);
    }

    @Transactional
    public void modificar(String idObraSocial, String nombre, Long telefono, String plan) {

        ObraSocial obraSocial = obraSocialRepositorio.findById(idObraSocial).orElse(null);
        if (obraSocial != null) {
            obraSocial.setTelefono(telefono);
            obraSocial.setNombre(nombre);
            obraSocial.setPlan(plan);
            obraSocialRepositorio.save(obraSocial);
        }
    }

    @Transactional(readOnly = true)
    public ObraSocial buscarPorId(String idObraSocial) {

        return obraSocialRepositorio.findById(idObraSocial).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<ObraSocial> buscarTodasObrasSocial(){
       return obraSocialRepositorio.findAll();
    }

    @Transactional
    public void eliminarObraSocial(String idObraSocial){
            obraSocialRepositorio.deleteById(idObraSocial);
    }

    public void validarPaciente(ObraSocial obraSocial) throws ExcepcionKinessysObraSocial {
        if(obraSocial.getNombre() == null || obraSocial.getNombre().isEmpty()){
            throw new ExcepcionKinessysObraSocial ("El nombre no puede ser nulo");
        }

        if(obraSocial.getTelefono() == null){
            throw new ExcepcionKinessysObraSocial ("El telefono no puede ser nulo");
        }

        if(obraSocial.getPlan() == null || obraSocial.getPlan().isEmpty()){
            throw new ExcepcionKinessysObraSocial ("El plan no puede ser nulo");
        }

    }
}
