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
                    .antMatchers("/img").permitAll()
                    .antMatchers("/**").permitAll()//.authenticated()
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
                    .logoutSuccessUrl("/home")
                    .permitAll()
                    .deleteCookies("JSESSIOND")
                .and()
                    .exceptionHandling().accessDeniedPage("/error")
                    .and()
                    .csrf().disable();

    }

}
