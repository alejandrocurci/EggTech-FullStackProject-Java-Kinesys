package com.kinesysApp.kinesys;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.security.PermitAll;

@Configuration
public class ConfigSeguridad extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(HttpSecurity httpSeguridad) throws Exception{
        httpSeguridad.headers().frameOptions().sameOrigin()
                .and()
                    .authorizeRequests()
                    .antMatchers("/img/*","/*.jpeg","/*.jpg","/*.png","/*.css",
                            "/pacientes/crear","/pacientes/guardar",
                            "/profesionales/crear","/profesionales/guardar", "/").permitAll()

                    //.antMatchers("/**").permitAll()
                    .antMatchers("/**").authenticated()
                .and()
                   .formLogin()
                   .loginPage("/login").loginProcessingUrl("/logincheck")
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
