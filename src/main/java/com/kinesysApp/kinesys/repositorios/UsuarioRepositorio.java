package com.kinesysApp.kinesys.repositorios;

import com.kinesysApp.kinesys.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,String> {

    @Query("SELECT u FROM Usuario u WHERE u.nombreU = :nombreU")
    Usuario buscarPorNombreDeUsuario(@Param("nombreU")String nombreU);

    Usuario findByNombreU(String nombreU);
}
