package com.kinesysApp.kinesys;

import com.kinesysApp.kinesys.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.security.PermitAll;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ConfigSeguridad extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioServicio  Usuarioservicio;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(Usuarioservicio) // le pasamos cual es el servicio que debe utilizara para autentificar un usuario
                .passwordEncoder(encoder); // cuando lo encuentra al usuario le pasamamos el encoder que debe utilzar para encriptar la contraseña
    }
    @Override
    public void configure(HttpSecurity httpSeguridad) throws Exception{
        httpSeguridad.headers().frameOptions().sameOrigin()
                .and()
                    .authorizeRequests()
                    .antMatchers("/img/*","/*.jpeg","/*.jpg","/*.png","/*.css",
                            "/pacientes/crear","/pacientes/guardar",
                            "/profesionales/crear","/profesionales/guardar", "/").permitAll()

                .antMatchers("/**").permitAll()
               //.antMatchers("/**").authenticated()
                .and()
                   .formLogin()
                   .loginPage("/login")
                   .loginProcessingUrl("/logincheck")
                   .usernameParameter("nombreU")
                   .passwordParameter("password")
                   .defaultSuccessUrl("/index",true)
                   .permitAll()
                .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                    .permitAll()
                    .deleteCookies("JSESSIOND")
                .and()
                    .exceptionHandling().accessDeniedPage("/error")
                .and()
                    .csrf().disable();

    }

}
