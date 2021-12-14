package br.sicredi.airbnb.demo.exception.usuario;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class DadosInvalidosCadastroException extends RuntimeException{

    public DadosInvalidosCadastroException(){
        super();
    }
}
