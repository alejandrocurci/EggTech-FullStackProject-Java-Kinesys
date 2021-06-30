package com.kinesysApp.kinesys.entidades;

import java.io.Serializable;
import com.kinesysApp.kinesys.roles.Rol;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idPaciente;

    //@NotEmpty
    @Column(unique = true)
    private Long dni ;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String apellido;

    @NotEmpty
    private String  telefono;

    @NotEmpty
    @Email
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuarioPaciente;

    @ManyToOne
    private Rol rolPaciente;




    
    
   
  
    
    
}
