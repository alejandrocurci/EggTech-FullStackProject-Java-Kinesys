package com.kinesysApp.kinesys.servicios;

import com.kinesysApp.kinesys.entidades.Paciente;
import com.kinesysApp.kinesys.entidades.Zona;
import com.kinesysApp.kinesys.repositorios.PacienteRepositorio;
import com.kinesysApp.kinesys.repositorios.ZonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZonaServicio {

    @Autowired
    private ZonaRepositorio zonaRepositorio;

    public void crear(String provincia, String localidad, String domicilio) {

        Zona zona = new Zona();
        zona.setProvincia(provincia);
        zona.setLocalidad(localidad);
        zona.setDomicilio(domicilio);
        zonaRepositorio.save(zona);
    }

    public List<Zona> buscarTodas() {
        return zonaRepositorio.findAll();
    }

    public void eliminar(String idZona) {
        zonaRepositorio.deleteById(idZona);
    }

    public void modificar(String idZona, String provincia, String localidad, String domicilio) {
        Zona zona = zonaRepositorio.findById(idZona).orElse(null);
        if (zona != null) {
            zona.setProvincia(provincia);
            zona.setLocalidad(localidad);
            zona.setDomicilio(domicilio);
            zonaRepositorio.save(zona);
        }
    }

    public Zona buscarPorId(String idZona) {
        return zonaRepositorio.findById(idZona).orElse(null);
    }
}
