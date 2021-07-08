package com.kinesysApp.kinesys.repositorios;

import com.kinesysApp.kinesys.roles.Rol;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RolRepositorio extends JpaRepository<Rol,String>{

    Rol findByNombre(String nombre);

}
