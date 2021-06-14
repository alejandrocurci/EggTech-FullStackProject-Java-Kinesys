package com.kinesysApp.kinesys.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import javax.persistence.Entity;

@Data
@Entity
public class Paciente {

    @Id
    private Long dni ;
    private String nombre;
    private String apellido;
    private Integer edad;
    private Integer telefono;
    private String email;
    private ObraSocial obraSocial;
}
