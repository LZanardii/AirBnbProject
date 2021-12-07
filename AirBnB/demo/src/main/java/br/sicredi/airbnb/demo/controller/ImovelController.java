package br.sicredi.airbnb.demo.controller;

import br.sicredi.airbnb.demo.model.ImovelModel;
import br.sicredi.airbnb.demo.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImovelController {

    @Autowired
    ImovelService imovelService;

    @PostMapping("/imoveis")
    public ResponseEntity<?> createImovel(@RequestBody ImovelModel imovelModel) {
        try {
            imovelService.createImovel(imovelModel);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception error){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
