package br.sicredi.airbnb.demo.controller;

import br.sicredi.airbnb.demo.exception.LogException;
import br.sicredi.airbnb.demo.model.ImovelModel;
import br.sicredi.airbnb.demo.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class ImovelController {

    @Autowired
    ImovelService imovelService;

    @PostMapping("/novo-imovel")
    public ResponseEntity<Object> createImovel(@RequestBody ImovelModel imovelModel) {
        try {
            imovelService.createImovel(imovelModel);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception error){
            LogException.error(HttpStatus.BAD_REQUEST, "Input invalido");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/aluga-imovel")
    public ResponseEntity<Object> rentImovel(@RequestParam String nomeImovel){
        try {
            imovelService.rentImovel(nomeImovel.toUpperCase());
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception error){
            LogException.error(HttpStatus.BAD_REQUEST, "input inválido");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }

}
