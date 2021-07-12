package com.kinesysApp.kinesys.entidades;

import com.kinesysApp.kinesys.enumeraciones.Especialidad;
import com.kinesysApp.kinesys.enumeraciones.Sexo;

import java.io.Serializable;

import com.kinesysApp.kinesys.roles.Rol;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
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

    @Column(unique = true)
    @NotNull(message = "El dni es requerido")
    private Long dni;

    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @NotBlank(message = "El apellido es requerido")
    private String apellido;

    @NotNull(message = "La edad es requerida")
    @Min(value = 1, message = "Edad minima de 1 año")
    @Max(value = 120, message = "Edad maxima de 120 año")
    private Integer edad;

    @NotNull(message = "El telefono es requerido")
    @Min(value = 1000000, message = "Minimo de 7 digitos")
    @Max(value = 999999999, message = "Maximo de 9 digitos")
    private Long telefono;

    @NotBlank(message = "El email es requerido")
    @Email(message = "Email invalido")
    private String email;

    @NotNull(message = "La matricula es requerida")
    @Min(value = 1, message = "Minimo de 1 digito")
    @Max(value = 999999, message = "Maximo de 6 digitos")
    private Integer matricula;

    @NotNull(message = "La especialidad es requerida")
    private Especialidad especialidad;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Zona> zonaProfesionales;

    @ManyToMany
    private List<ObraSocial> obraSocialProfesionales;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "El sexo es requerido")
    private Sexo sexo;

    @Valid
    @OneToOne(cascade = CascadeType.ALL) // cascade = CascadeType.ALL es para indicar que se guarde automaticamente en la tabla
    private Usuario usuarioProfesional;

    @ManyToOne
    private Rol rolProfesional;
}
