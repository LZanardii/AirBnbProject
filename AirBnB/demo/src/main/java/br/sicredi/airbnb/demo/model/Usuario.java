package br.sicredi.airbnb.demo.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
 
	
	@Id
	private long id;
	@NonNull
	private String user;
	@NonNull
	private String senha;
	@NonNull
	private String tipo;
	@NonNull
	private boolean logado;


}
