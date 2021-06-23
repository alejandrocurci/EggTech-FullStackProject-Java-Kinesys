
package com.kinesysApp.kinesys.repositorios;

import com.kinesysApp.kinesys.entidades.ObraSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraSocialRepositorio extends JpaRepository<ObraSocial,String>{
    
}
