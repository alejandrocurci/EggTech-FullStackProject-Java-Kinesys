
package com.kinesysApp.kinesys.repositorios;


import com.kinesysApp.kinesys.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PacienteRepositorio extends JpaRepository<Paciente,String>{
    //@Query("SELECT p FROM Paciente p WHERE p.dni = :dni")
   // Paciente BuscarPorDni(@Param("dni")Long dni );

    Paciente findByDni(Long dni);
    List<Paciente> findByNombre(String nombre);

}
