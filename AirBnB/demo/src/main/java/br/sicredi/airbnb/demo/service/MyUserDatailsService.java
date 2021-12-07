package br.sicredi.airbnb.demo.service;

import br.sicredi.airbnb.demo.model.UsuarioModel;
import br.sicredi.airbnb.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;


@Service
public class MyUserDatailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional//feito em somente uma transação
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UsuarioModel usuarioModel = usuarioRepository.findByNomeUsuario(userName);

        if (usuarioModel != null){
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(usuarioModel.getRole());
            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(authority);
            User userSpring = new User(usuarioModel.getNomeUsuario(), usuarioModel.getSenha(), authorities);
            return userSpring;
        }

        return null;
    }
}
