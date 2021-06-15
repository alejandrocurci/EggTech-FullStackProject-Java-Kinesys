/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kinesysApp.kinesys.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author flor
 */
@Data
@Entity
public class Zona implements Serializable {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idZona;
    private String provincia;
    private String localidad;
    private String domicilio;
    
    
    @ManyToOne
   private Profesional profesional;
    
    
}
