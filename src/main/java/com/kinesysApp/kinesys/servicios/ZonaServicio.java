package com.kinesysApp.kinesys.servicios;

import com.kinesysApp.kinesys.entidades.Zona;
import com.kinesysApp.kinesys.enumeraciones.Provincia;
import com.kinesysApp.kinesys.repositorios.ZonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ZonaServicio {

    @Autowired
    private ZonaRepositorio zonaRepositorio;

    @Transactional
    public void crear(Zona zona) {

        zonaRepositorio.save(zona);

    }
    @Transactional(readOnly = true)
    public List<Zona> buscarTodas() {
        return zonaRepositorio.findAll();
    }

    @Transactional
    public void eliminarZona(String idZona) {
        zonaRepositorio.deleteById(idZona);
    }

    @Transactional
    public void modificar(String idZona, Provincia provincia, String localidad, String domicilio) {

        Zona zona = zonaRepositorio.findById(idZona).orElse(null);

        if (zona != null) {
            zona.setProvincia(provincia);
            zona.setLocalidad(localidad);
            zona.setDomicilio(domicilio);
            zonaRepositorio.save(zona);
        }
    }
    @Transactional(readOnly = true)
    public Zona buscarPorId(String idZona) {
        return zonaRepositorio.findById(idZona).orElse(null);
    }
}
