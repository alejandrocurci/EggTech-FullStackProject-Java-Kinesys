package com.kinesysApp.kinesys.entidades;

import com.kinesysApp.kinesys.roles.Rol;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")   //(strategy = GenerationType.IDENTITY) <--- solo para tipos numericos
    private String id;

    @NotBlank(message = "El usuario es requerido")
    @Column(unique = true)    // Para que no se pueda repetir el nombre de usuario...
    private String nombreU;

    @NotBlank(message = "La contraseña es requerida")
    private String clave;

    @OneToOne
    private Paciente ListaPaciente;

    @OneToOne
    private Profesional listaProfesional;

    @ManyToOne
    private Rol rol;

}
