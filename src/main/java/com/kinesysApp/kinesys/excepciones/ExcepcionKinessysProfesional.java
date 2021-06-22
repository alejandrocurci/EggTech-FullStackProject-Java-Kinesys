package com.kinesysApp.kinesys.excepciones;

import org.springframework.security.access.event.PublicInvocationEvent;

public class ExcepcionKinessysProfesional extends Exception {
    public ExcepcionKinessysProfesional(String mensaje){
        super(mensaje);
    }
}
