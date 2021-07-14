
package com.kinesysApp.kinesys.repositorios;


import com.kinesysApp.kinesys.entidades.Profesional;
import com.kinesysApp.kinesys.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProfesionalRepositorio extends JpaRepository<Profesional,String>{

    @Query("SELECT p FROM Profesional p WHERE p.usuarioProfesional IS :usuarioProfesional")
    Profesional buscarPorUsuario(@Param("usuario")Usuario usuario);
}
