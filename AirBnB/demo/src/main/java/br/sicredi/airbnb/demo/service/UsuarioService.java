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

	  static ArrayList<Usuario> usuariosLogados = new ArrayList<>();

	  public List<Usuario> getAllusers()
	  {
		  return repositoryUsuario.findAll();
	  }

	  public String createUser(Usuario user)
	  {
		List<Usuario> listUsuarios = getAllusers();

		if(listUsuarios.stream().anyMatch(Usuario -> Usuario.getId() == user.getId()))
		{
			return "Usuario ja cadastrado.";
		}
		else
		{
			 repositoryUsuario.save(user);

			return "Usuario cadastrado com sucesso.";
		}

	  }
	
	  public String LoginUser(String user, String pass)
	  {
		List<Usuario> listUsuarios = getAllusers();   
		 // achou usuario, senha e logado false
		if(listUsuarios.stream().anyMatch(Usuario -> Usuario.getSenha().equals(pass) && Usuario.getUser().equals(user) && !Usuario.isLogado()))
		{
		   listUsuarios.stream().filter(Usuario -> Usuario.getSenha().equals(pass) && Usuario.getUser().equals(user)).findFirst().get().setLogado(true);
		   
		   usuariosLogados.add(listUsuarios.stream().filter(Usuario -> Usuario.getSenha().equals(pass) && Usuario.getUser().equals(user)).findFirst().get());

		   return "Usuario autenticado.";

		}
		else
		{
			return "Não foi possivel realizar a autenticacao";		
		}
	  }
	
	  public String LogoffUser(String user, String pass)
	  {
		List<Usuario> listUsuarios = getAllusers();   

		// achou usuario, senha e logado true
		if(listUsuarios.stream().anyMatch(Usuario -> Usuario.getSenha().equals(pass) && Usuario.getUser().equals(user) && Usuario.isLogado()))
		{
		   listUsuarios.stream().filter(Usuario -> Usuario.getSenha().equals(pass) && Usuario.getUser().equals(user)).findFirst().get().setLogado(false);
		   
		   usuariosLogados.remove(listUsuarios.stream().filter(Usuario -> Usuario.getSenha().equals(pass) && Usuario.getUser().equals(user)).findFirst().get());
		   
		   return "Desconectado com sucesso.";	
		}
		else
		{
			return "Não foi possivel desconectar";		
		}
	
		
	  }
}
