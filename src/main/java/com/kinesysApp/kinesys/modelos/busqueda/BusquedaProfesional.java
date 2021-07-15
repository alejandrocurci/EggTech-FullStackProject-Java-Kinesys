package com.kinesysApp.kinesys.modelos.busqueda;

import com.kinesysApp.kinesys.enumeraciones.Especialidad;
import com.kinesysApp.kinesys.enumeraciones.Provincia;
import lombok.Data;

@Data
public class BusquedaProfesional {


    private Especialidad especialidad;
    private Provincia provincia;
    private String idObraSocial;

    public BusquedaProfesional () {
        provincia=null;
        especialidad=null;
        idObraSocial ="";
    }

}
