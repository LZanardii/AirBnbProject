package br.sicredi.airbnb.demo.model;

import lombok.*;
import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Usuarios")
public class UsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(unique = true, nullable = false)
	private String nomeUsuario;

	@Column(nullable = false)
	private String senha;

	@Column(nullable = false)
	private String role;

	public UsuarioModel(String nomeUsuario, String senha, String role) {
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.role = role;
	}
}
