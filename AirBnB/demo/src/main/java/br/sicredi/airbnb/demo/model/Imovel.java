package br.sicredi.airbnb.demo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Imovel {

	@Id
	private long id;
	@NonNull
	private long idLocador;
	@NonNull
	private String nome;
	@NonNull
	private String cidade;
	@NonNull
	private String tipo;
	@NonNull
	private double preco;
	@NonNull
	private boolean disponivel;


}
