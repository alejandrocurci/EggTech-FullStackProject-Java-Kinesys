package com.kinesysApp.kinesys;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration  //indica que la clase puede ser utilizada por el contenedor spring como una fuente de definiciones beans
public class ConfigAplicacion {
    @Bean  // cuando creamos un bean podemos inyectarlo en otras clases.
    // inyectar una anotacion de el objeto BCryptPasswordEncoder para poder usarlo
    // nos permite crear nuevos onjetos y utilizarlos
    public BCryptPasswordEncoder encoder() {    //"BCryptPasswordEncoder"clase para que usamos para encriptar las contraseñas

        return new BCryptPasswordEncoder();
    }
}
