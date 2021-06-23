package com.kinesysApp.kinesys.entidades;

import com.kinesysApp.kinesys.enumeraciones.Sexo;

import java.io.Serializable;

import com.kinesysApp.kinesys.roles.Rol;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "Profesionales")   /*Hemos definidos las siguientes propiedades de la anotación @JoinTable*/
public class Profesional implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idProfesional;
    private Long dni;
    private String nombre;
    private String apellido;
    private Integer edad;
    private Long telefono;
    private String email;
    private Integer matricula;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Zona> zonaProfesionales;

   /* name: Nombre de la tabla que será creada físicamente en la base de datos.
   joinColumns: Corresponde al nombre para el ID de la Entidad Book.
   inverseJoinColumns: Corresponde al nombre para el ID de la Entidad Author*/

   /*@JoinTable(name = "relacion_prof_Osocial",
    joinColumns = @JoinColumn(name = "FK_profesional",nullable = false),
    inverseJoinColumns = @JoinColumn(name = "FK_obrasoial",nullable = false) //@Column(nullable = false) afecta al esquema de la base de datos haciendo que la columna pueda ser null,
                                                                                    // tampoco compila si al objeto se le pone null en un campo, pero el error es por parte del gestor de la base de datos y no de java.
    )*/
    @ManyToMany
    private List<ObraSocial> obraSocialProfesionales;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @OneToOne(cascade = CascadeType.ALL) // cascade = CascadeType.ALL es para indicar que se guarde automaticamente en la tabla
    private Usuario usuarioProfesional;

    @ManyToOne
    private Rol rolProfesional;
}
