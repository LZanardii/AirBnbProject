package br.sicredi.airbnb.demo.repository;

import br.sicredi.airbnb.demo.model.ImovelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<ImovelModel, Long>{

    ImovelModel findByNomeImovel(String nomeImovel);

}
