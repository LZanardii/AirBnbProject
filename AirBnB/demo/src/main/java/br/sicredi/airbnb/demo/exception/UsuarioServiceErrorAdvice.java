package br.sicredi.airbnb.demo.exception;

import br.sicredi.airbnb.demo.exception.usuario.DadosInvalidosCadastroException;
import br.sicredi.airbnb.demo.exception.usuario.UsuarioJaCadastradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class UsuarioServiceErrorAdvice {

    @ExceptionHandler({UsuarioJaCadastradoException.class})
    public ResponseEntity<String> handleUsuarioJaCadastradoExeption(UsuarioJaCadastradoException exception){
        return LogException.error(HttpStatus.UNPROCESSABLE_ENTITY,
                "Cadastro já existente no sistema, revise seu input.");
    }

    @ExceptionHandler({DadosInvalidosCadastroException.class})
    public ResponseEntity<String> dadosInvalidosCadastroException(DadosInvalidosCadastroException exception){
        return LogException.error(HttpStatus.UNPROCESSABLE_ENTITY,
                "Revise a ROLE do usuario que deseja cadastrar.");
    }
}
