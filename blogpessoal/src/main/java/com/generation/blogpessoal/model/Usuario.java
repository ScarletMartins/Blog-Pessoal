package com.generation.blogpessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // informa que trata-se de uma entidade que se tornará uma tabela
@Table(name = "tb_usuarios") // cria e nomea tabela
public class Usuario {

	@Id // identifica que o atributo é um identificador único (Primary key)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // atribui um auto-incremento ao id
	private Long id;

	@NotBlank(message = "O atributo é obrigatório!")
	private String nome;

	@NotBlank(message = "O atributo é obrigatório!")
	@Email(message = "O atributo deve ser um email válido")
	private String usuario;

	@NotBlank(message = "O atributo é obrigatório!")
	@Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
	private String senha;

	private String foto;

	// remove tudo que está relacionado ao usuario caso este user seja apagado
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE) // um usuario para muitas postagens
	@JsonIgnoreProperties("usuario") // ignora as propriedades do usuario, pra evitar um lopping infinito
	private List<Postagem> postagem;

	public Usuario(Long id, String nome, String usuario, String senha, String foto) {
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.foto = foto;
	}
	
	public Usuario() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

}
