package br.sicredi.airbnb.demo.controller;


import br.sicredi.airbnb.demo.exception.LogException;
import br.sicredi.airbnb.demo.model.UsuarioModel;
import br.sicredi.airbnb.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<?> getAllUsuarios(){
        return new ResponseEntity<>(usuarioService.listAllUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable("id") long id){
        Optional<UsuarioModel> user = usuarioService.findUsuarioById(id);
        if (user.isEmpty()) {
            LogException.error(HttpStatus.NOT_FOUND, "<h1>Usuario não encontrado.</h1>");
            return new ResponseEntity<>("<h1>Usuário não encontrado</h1>",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/usuarios/create")
    public ResponseEntity<?> createUsuario(@RequestBody UsuarioModel usuarioModel){
        String created = usuarioService.createUser(usuarioModel);
        if (created.equals("Usuario cadastrado com sucesso.")){
            return new ResponseEntity<>("<h1>Usuario criado com sucesso.</h1>",HttpStatus.CREATED);
        }
        LogException.error(HttpStatus.BAD_REQUEST, "<h1>Erro de input do usuário.</h1>");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("<h1>Input inválido.</h1>");
    }

}
