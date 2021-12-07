package br.sicredi.airbnb.demo.model;


import lombok.Getter;

@Getter
public enum Role {

    LOCADOR("LOCADOR"),
    LOCATARIO("LOCATARIO"),
    ADMIN("ADMIN");

    private String nome;

    Role(String nome){
        this.nome = nome;
    }

}
