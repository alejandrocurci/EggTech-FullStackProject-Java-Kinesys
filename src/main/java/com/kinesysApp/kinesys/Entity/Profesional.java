package com.kinesysApp.kinesys.Entity;

import com.kinesysApp.kinesys.enumeraciones.Sexo;
import java.io.Serializable;
import lombok.Data;

import javax.persistence.Entity;
import java.util.List;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
    

   @OneToMany(mappedBy = "profesional",fetch = FetchType.EAGER)
    private List<Zona> zonasProf;
   
   @ManyToMany
   private List<ObraSocial> listObraSocial;
    
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

}
