package br.sicredi.airbnb.demo.repository;

import br.sicredi.airbnb.demo.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryImovel extends JpaRepository<Imovel, Long>{

}
