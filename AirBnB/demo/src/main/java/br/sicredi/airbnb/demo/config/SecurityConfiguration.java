package br.sicredi.airbnb.demo.config;

import br.sicredi.airbnb.demo.model.Role;

import br.sicredi.airbnb.demo.service.MyUserDatailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;



@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDatailsService myUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/usuarios/**").hasAuthority(Role.ADMIN.getNome())
                .antMatchers("/imoveis/**").hasAuthority(Role.LOCATARIO.getNome())
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
//                .formLogin().permitAll()
//                .and()
//                .logout().permitAll()
//                .and()
                .csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{

        auth.userDetailsService(myUserDetailsService)
            .passwordEncoder(NoOpPasswordEncoder.getInstance());


    }
}
