package com.kinesysApp.kinesys.Entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@Entity
public class Especialidad {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idEspecialidad ;

    private String nombre;
    @ManyToOne
    private List<Profesional> profesional;

}
