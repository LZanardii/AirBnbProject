package br.sicredi.airbnb.demo.controller;


import br.sicredi.airbnb.demo.dto.UsuarioModelDto;
import br.sicredi.airbnb.demo.exception.LogException;
import br.sicredi.airbnb.demo.model.UsuarioModel;
import br.sicredi.airbnb.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<UsuarioModelDto> getAllUsuarios(){
        return UsuarioModelDto.conversor(usuarioService.listAllUsuarios());
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Object> getUsuarioById(@PathVariable("id") long id){
        Optional<UsuarioModel> user = usuarioService.findUsuarioById(id);
        if (user.isEmpty()) {
            LogException.error(HttpStatus.NOT_FOUND, "<h1>Usuario não encontrado.</h1>");
            return new ResponseEntity<>("<h1>Usuário não encontrado</h1>",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/usuarios/create")
    public ResponseEntity<Object> createUsuario(@RequestBody UsuarioModel usuarioModel){
        return new ResponseEntity<>(usuarioService.createUser(usuarioModel), HttpStatus.CREATED);
    }

}
