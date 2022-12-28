package com.co.sg.proyectopostal.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class AuthenticationConfig extends WebSecurityConfigurerAdapter {
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/registroUsuario").hasRole("Administrador")
                .antMatchers("/cargarArchivo").hasRole("User")
                .antMatchers("/").permitAll()
                .and().formLogin();
        http.csrf().disable();
    }

    //@Bean
    //public BCryptPasswordEncoder bcryptPasswordEncoder(){
        //return new BCryptPasswordEncoder();
    //}





  

}