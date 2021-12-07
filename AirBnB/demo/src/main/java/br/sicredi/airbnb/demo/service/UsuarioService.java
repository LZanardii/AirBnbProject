package br.sicredi.airbnb.demo.service;

import java.util.List;
import java.util.Optional;

import br.sicredi.airbnb.demo.model.Role;
import br.sicredi.airbnb.demo.model.UsuarioModel;
import br.sicredi.airbnb.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioService {

	  @Autowired
	  UsuarioRepository repositoryUsuario;



	  public List<UsuarioModel> listAllUsuarios() {

		  return repositoryUsuario.findAll();
	  }

	  public String createUser(UsuarioModel user) {
		  if (user.getRole().toUpperCase().equals(Role.ADMIN.getNome())
				  || user.getRole().toUpperCase().equals(Role.LOCADOR.getNome())
				  || user.getRole().toUpperCase().equals(Role.LOCATARIO.getNome()) ){

			  List<UsuarioModel> listUsuarios = listAllUsuarios();
			  if(listUsuarios.stream().anyMatch((usuarioModel -> usuarioModel.getNomeUsuario().equals(user.getNomeUsuario())))) {
				  return "Usuario ja existente no sistema.";
			  }
			  else {
				  user.setRole(user.getRole().toUpperCase());
				  repositoryUsuario.save(user);
				  return "Usuario cadastrado com sucesso.";
			  }
		  }
		  return "Tipo de usuário incorreto.";
	  }

	  public Optional<UsuarioModel> findUsuarioById(long id){
		  return repositoryUsuario.findById(id);
	  }

	  public UsuarioModel findUsuarioByUsername(String username){
		  return repositoryUsuario.findByNomeUsuario(username);
	  }

	  public List<UsuarioModel> findAllByTipo(String tipo){
		  return repositoryUsuario.findByRole(tipo);
	  }

}
