package br.sicredi.airbnb.demo.exception.usuario;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UsuarioJaCadastradoException extends RuntimeException {

    public UsuarioJaCadastradoException(){
        super();
    }
}
