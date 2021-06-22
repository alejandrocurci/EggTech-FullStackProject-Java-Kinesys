package com.kinesysApp.kinesys.entidades;

import java.io.Serializable;
import java.util.List;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class ObraSocial implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idObraSocial;

    private String nombre;

    private Long telefono;

    private String Plan;



}
