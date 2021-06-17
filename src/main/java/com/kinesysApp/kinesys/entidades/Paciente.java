package com.kinesysApp.kinesys.entidades;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idPaciente;

    @Column(unique = true)
    private Long dni ;

    private String nombre;

    private String apellido;

    private Integer telefono;

    private String email;

    @OneToOne
    private Usuario usuarioPaciente;




    
    
   
  
    
    
}
