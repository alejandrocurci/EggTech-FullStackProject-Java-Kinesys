package com.kinesysApp.kinesys.entidades;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idPaciente;

    @NotBlank(message ="El Dni no puede estar vacio")
    @Column(unique = true)
    private Long dni ;

    private String nombre;

    private String apellido;

    private Integer telefono;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuarioPaciente;




    
    
   
  
    
    
}
