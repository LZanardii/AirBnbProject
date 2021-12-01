package br.sicredi.airbnb.demo.config;

import br.sicredi.airbnb.demo.model.Usuario;
import br.sicredi.airbnb.demo.repository.RepositoryUsuario;
import br.sicredi.airbnb.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class  SecurityConfig extends WebSecurityConfigurerAdapter {

    RepositoryUsuario repositoryUsuario;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Leonardo")
                .password("{noop}1234").roles("LOCADOR");
        auth.inMemoryAuthentication()
                .withUser("Lucas")
                .password("{noop}1234").roles("LOCATARIO");

    }

}
