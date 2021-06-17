
package com.kinesysApp.kinesys.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.kinesysApp.kinesys.enumeraciones.Provincia;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class Zona implements Serializable {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idZona;
    private Provincia provincia;
    private String localidad;
    private String domicilio;
    
    
    @ManyToOne
   private Profesional profesional;
    
    
}
