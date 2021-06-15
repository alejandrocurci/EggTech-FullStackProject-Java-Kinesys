/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kinesysApp.kinesys.repositorios;

import com.kinesysApp.kinesys.Entity.ObraSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author flor
 */
@Repository
public interface ObraSocialRepositorio extends JpaRepository<ObraSocial,String>{
    
}
