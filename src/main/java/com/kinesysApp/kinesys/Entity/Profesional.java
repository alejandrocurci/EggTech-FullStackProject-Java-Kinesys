package com.kinesysApp.kinesys.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import java.util.List;

@Data
@Entity
public class Profesional {


    @Id
    private Long dni ;
    private String nombre;
    private String apellido;
    private Integer edad;
    private Integer telefono;
    private String email;
    private Integer matricula;

    private List<Especialidad> especialidad;



}
