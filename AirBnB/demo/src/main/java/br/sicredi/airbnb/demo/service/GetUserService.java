package br.sicredi.airbnb.demo.service;

import lombok.NoArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;



@NoArgsConstructor
@Component
public class GetUserService {

    public static String UsuarioLogado(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
