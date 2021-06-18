package com.kinesysApp.kinesys.entidades;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")   //(strategy = GenerationType.IDENTITY) <--- solo para tipos numericos
    private String id;

    @Column(unique = true)    // Para que no se pueda repetir el nombre de usuario...
    private String nombreU;

    private String clave;

    @OneToOne
    private Paciente ListaPaciente;

    @OneToOne
    private Profesional listaProfesional;

}
