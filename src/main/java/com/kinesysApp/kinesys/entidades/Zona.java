
package com.kinesysApp.kinesys.entidades;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @NotNull(message = "La provincia es requerida")
    private Provincia provincia;

    @NotBlank(message = "La localidad es requerida")
    private String localidad;

    @NotBlank(message = "La localidad es requerida")
    private String domicilio;
    
    

    
    
}
