
package com.kinesysApp.kinesys.entidades;

import java.io.Serializable;
import javax.persistence.*;

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
    
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Profesional profesional;
    
    
}
