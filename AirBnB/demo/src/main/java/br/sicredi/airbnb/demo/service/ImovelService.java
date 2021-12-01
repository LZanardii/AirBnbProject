package br.sicredi.airbnb.demo.service;



import br.sicredi.airbnb.demo.model.Imovel;
import br.sicredi.airbnb.demo.repository.RepositoryImovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ImovelService {


	@Autowired
	RepositoryImovel repositoryImovel;


	public List<Imovel> getAllImovel() {
		return repositoryImovel.findAll();
	}


	public String createImovel(Imovel imovel, Long id) {

		if (UsuarioService.usuariosLogados.stream().
				anyMatch(usuario -> usuario.getId() == id && usuario.getTipo().equals("LOCADOR"))) {
			repositoryImovel.save(imovel);
			return "Imóvel cadastrado com sucesso";
		}

		return "Imóvel não cadastrado";
	}
}

