package com.kinesysApp.kinesys.entidades;

import com.kinesysApp.kinesys.enumeraciones.Sexo;
import java.io.Serializable;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
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
    

   @OneToMany(mappedBy = "profesional",cascade = CascadeType.ALL)
    private List<Zona> zonasProf;
   
   @ManyToMany
   private List<ObraSocial> listObraSocial;
    
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuarioProfesional;

}
