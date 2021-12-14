package br.sicredi.airbnb.demo.dto;

import br.sicredi.airbnb.demo.model.UsuarioModel;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UsuarioModelDto {

    private long id;
    private String nomeUsuario;
    private String role;

    public UsuarioModelDto(UsuarioModel usuarioModel){
        this.id = usuarioModel.getId();
        this.nomeUsuario = usuarioModel.getNomeUsuario();
        this.role = usuarioModel.getRole();
    }

    public static List<UsuarioModelDto> conversor(List<UsuarioModel> usuarioModels){
        return usuarioModels.stream().map(UsuarioModelDto::new).collect(Collectors.toList());
    }

}
