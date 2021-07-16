package com.kinesysApp.kinesys.entidades;

import java.io.Serializable;
import java.util.List;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class ObraSocial implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idObraSocial;

    @NotBlank(message = "El nombre es requerido")
    private String nombre;


    private Long telefono;


    private String Plan;

}
