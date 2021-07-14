package com.kinesysApp.kinesys.servicios;

import com.kinesysApp.kinesys.repositorios.RolRepositorio;
import com.kinesysApp.kinesys.roles.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RolServicio {

    @Autowired
    private RolRepositorio rolRepositorio;

    @Transactional
    public void crear(String nombre){
        Rol rol = new Rol();
        rol.setNombre(nombre.toUpperCase());
        rolRepositorio.save(rol);
    }

    @Transactional(readOnly = true)
    public Rol buscarPorNombre(String nombreRol){
        Rol rol = rolRepositorio.findByNombre(nombreRol);
        return rol;
    }

    @Transactional
    public void elimiarRol(String idRol)throws Exception{
        Rol respRol=rolRepositorio.findById(idRol).orElse(null);
        if(respRol == null){
            throw new Exception("El nombre del Rol no se encuentra en la BBDD");
        }else{
            rolRepositorio.delete(respRol);
        }
    }

    @Transactional
    public List<Rol> buscarTodos() {
        return rolRepositorio.findAll();
    }

}
