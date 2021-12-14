package br.sicredi.airbnb.demo.service;

import java.util.List;
import java.util.Optional;

import br.sicredi.airbnb.demo.exception.usuario.DadosInvalidosCadastroException;
import br.sicredi.airbnb.demo.exception.usuario.UsuarioJaCadastradoException;
import br.sicredi.airbnb.demo.model.Role;
import br.sicredi.airbnb.demo.model.UsuarioModel;
import br.sicredi.airbnb.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioService {

	  @Autowired
	  UsuarioRepository usuarioRepository;



	  public List<UsuarioModel> listAllUsuarios() {

		  return usuarioRepository.findAll();
	  }

	  public String createUser(UsuarioModel user) {
		  if (user.getRole().toUpperCase().equals(Role.ADMIN.getNome())
				  || user.getRole().toUpperCase().equals(Role.LOCADOR.getNome())
				  || user.getRole().toUpperCase().equals(Role.LOCATARIO.getNome()) ){

			  user.setRole(user.getRole().toUpperCase());

			  try {
				  usuarioRepository.save(user);
				  return "Usuario cadastrado com sucesso.";
			  } catch (Exception error){
				  throw new UsuarioJaCadastradoException();
			  }
		  }
		  throw new DadosInvalidosCadastroException();
	  }

	  public Optional<UsuarioModel> findUsuarioById(long id){
		  return usuarioRepository.findById(id);
	  }

	  public UsuarioModel findUsuarioByUsername(String username){
		  return usuarioRepository.findByNomeUsuario(username);
	  }

	  public List<UsuarioModel> findAllByTipo(String tipo){
		  return usuarioRepository.findByRole(tipo);
	  }

}
