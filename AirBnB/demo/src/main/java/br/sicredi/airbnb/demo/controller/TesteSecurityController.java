package br.sicredi.airbnb.demo.controller;


import br.sicredi.airbnb.demo.model.Imovel;
import br.sicredi.airbnb.demo.service.ImovelService;
import br.sicredi.airbnb.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteSecurityController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ImovelService imovelService;

    @GetMapping("/teste")
    @PreAuthorize("hasRole('LOCADOR')")
    public String getTeste(){
        return "funcionou.";
    }

    @GetMapping("/createImovel")
    public String createImovel(@RequestBody Imovel imovel){
        return imovelService.createImovel(imovel);
    }

}
