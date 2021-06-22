
package com.kinesysApp.kinesys.repositorios;


import com.kinesysApp.kinesys.entidades.Paciente;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepositorio extends JpaRepository<Paciente,String>{
@Query("SELECT p FROM Paciente p WHERE p.dni = :dni")
    Paciente BuscarPorDni(@Param("dni")Long dni );

}
