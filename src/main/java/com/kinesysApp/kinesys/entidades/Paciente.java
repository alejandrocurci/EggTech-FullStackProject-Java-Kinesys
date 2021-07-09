package com.kinesysApp.kinesys.entidades;

import java.io.Serializable;
import com.kinesysApp.kinesys.roles.Rol;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idPaciente;

    @Column(unique = true)
    @NotNull(message = "El dni es requerido")
    private Long dni ;

    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @NotBlank(message = "El apellido es requerido")
    private String apellido;

    @Size(min = 7, max = 10, message = "Debe contener entre 7 y 10 digitos")
    private String  telefono;

    @NotBlank(message = "El email es requerido")
    @Email(message = "Email invalido")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuarioPaciente;

    @ManyToOne
    private Rol rolPaciente;




    
    
   
  
    
    
}
