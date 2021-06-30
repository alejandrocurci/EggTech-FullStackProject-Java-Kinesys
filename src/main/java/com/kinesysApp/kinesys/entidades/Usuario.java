package com.kinesysApp.kinesys.entidades;

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

    @NotBlank
    @Column(unique = true)    // Para que no se pueda repetir el nombre de usuario...
    private String nombreU;

    @NotBlank
    private String clave;

    @OneToOne
    private Paciente ListaPaciente;

    @OneToOne
    private Profesional listaProfesional;

}
