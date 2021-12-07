package br.sicredi.airbnb.demo.service;



import br.sicredi.airbnb.demo.model.ImovelModel;
import br.sicredi.airbnb.demo.repository.ImovelRepository;
import br.sicredi.airbnb.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ImovelService {

	@Autowired
	ImovelRepository imovelRepository;

	@Autowired
	UsuarioRepository usuarioRepository;


	public List<ImovelModel> getAllImovel() {
		return imovelRepository.findAll();
	}

	public String createImovel(ImovelModel imovel){

		imovel.setLocador(usuarioRepository.findByNomeUsuario(GetUserService.UsuarioLogado()));

		imovelRepository.save(imovel);

		return "Imóvel cadastrado.";

	}
}

