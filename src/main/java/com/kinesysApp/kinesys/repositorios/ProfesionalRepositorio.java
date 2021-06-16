/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kinesysApp.kinesys.repositorios;


import com.kinesysApp.kinesys.entidades.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author flor
 */

public interface ProfesionalRepositorio extends JpaRepository<Profesional,String>{
    
}
