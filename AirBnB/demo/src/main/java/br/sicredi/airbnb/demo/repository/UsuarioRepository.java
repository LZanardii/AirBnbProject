package br.sicredi.airbnb.demo.repository;

import br.sicredi.airbnb.demo.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{

    UsuarioModel findByNomeUsuario(String userName);

    List<UsuarioModel> findByRole(String tipo);

//    insert into usuarios
//    (id, password, role, user_name) values (1, 'adminPass', 'ADMIN', 'adminLeo')

}
