package br.sicredi.airbnb.demo.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NonNull
	private String user;
	@NonNull
	private String pwd;
	@NonNull
	private String type;



}
