package br.sicredi.airbnb.demo.service;

import java.util.ArrayList;
import java.util.List;

import br.sicredi.airbnb.demo.model.Usuario;
import br.sicredi.airbnb.demo.repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UsuarioService {

	  @Autowired
	  RepositoryUsuario repositoryUsuario;

	  public List<Usuario> getAllusers() {
		  return repositoryUsuario.findAll();
	  }

	  public String createUser(Usuario user) {
		List<Usuario> listUsuarios = getAllusers();

		if(listUsuarios.stream().anyMatch(Usuario -> Usuario.getId() == user.getId())) {
			return "Usuario ja cadastrado.";
		}
		else {
			 repositoryUsuario.save(user);
			return "Usuario cadastrado com sucesso.";
		}

	  }

}
