package br.sicredi.airbnb.demo.service;



import br.sicredi.airbnb.demo.model.ImovelModel;
import br.sicredi.airbnb.demo.model.UsuarioModel;
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

		getAllImovel().stream().filter(imovelModel -> !imovelModel.getNomeImovel()
				.equals(imovel.getNomeImovel())).findFirst().orElseThrow(RuntimeException::new);

		imovel.setLocador(findUsuarioLogado());
		imovel.setNomeImovel(imovel.getNomeImovel().toUpperCase());
		imovel.setCidade(imovel.getCidade().toUpperCase());
		imovel.setTipo(imovel.getTipo().toUpperCase());

		imovelRepository.save(imovel);

		return "Imóvel cadastrado.";

	}


	public String rentImovel(String nomeImovel) {

		ImovelModel imovel = imovelRepository.findByNomeImovel(nomeImovel);

		if (imovel != null && imovel.getLocatario() == null) {
			imovel.setLocatario(findUsuarioLogado());
			imovelRepository.save(imovel);
			return "Imóvel alugado com sucesso;";
		}else if (imovel != null && imovel.getLocatario() != null)
			throw  new RuntimeException();
		else
			throw  new RuntimeException();
	}

	public UsuarioModel findUsuarioLogado(){
		return usuarioRepository.findByNomeUsuario(GetUserService.UsuarioLogado());
	}
}

