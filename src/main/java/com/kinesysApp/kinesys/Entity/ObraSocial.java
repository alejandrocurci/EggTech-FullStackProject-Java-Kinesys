package com.kinesysApp.kinesys.Entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class ObraSocial {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idObraSocial ;
    private String nombre;
    private Integer telefono;
    private Especialidad especialidad;
}
