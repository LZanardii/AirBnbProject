package br.sicredi.airbnb.demo.model;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Imoveis")
public class ImovelModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idImovel;

	@Column(unique = true, nullable = false)
	private String nomeImovel;

	@Column(nullable = false)
	private String cidade;

	@Column(nullable = false)
	private String tipo;

	@Column(nullable = false)
	private double valor;

	@ManyToOne(targetEntity = UsuarioModel.class)
	@JoinColumn(name = "locador")
	@org.hibernate.annotations.ForeignKey(name = "locador_id_FK")
	private UsuarioModel locador;

	@OneToOne(targetEntity = UsuarioModel.class)
	@JoinColumn(name = "locatario")
	@org.hibernate.annotations.ForeignKey(name = "locatario_id_FK")
	private UsuarioModel locatario;

	public ImovelModel(String nomeImovel, String cidade, String tipo, double valor) {
		this.nomeImovel = nomeImovel;
		this.cidade = cidade;
		this.tipo = tipo;
		this.valor = valor;

	}
}
