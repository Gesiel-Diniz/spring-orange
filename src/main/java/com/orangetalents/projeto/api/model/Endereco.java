package com.orangetalents.projeto.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	private Usuario usuario;
	
	@NotBlank
	@Size(max = 255)
	@Column(name="logradouro", length = 255, nullable = false)
	private String logradouro;
	
	@NotBlank
	@Size(max = 10)
	@Column(name="numero", length = 10, nullable = false)
	private String numero;
	
	@NotBlank
	@Size(max = 255)
	@Column(name="complemento", length = 255, nullable = false)
	private String complemento;
	
	@NotBlank
	@Size(max = 150)
	@Column(name="bairro", length = 150, nullable = false)
	private String bairro;
	
	@NotBlank
	@Size(max = 150)
	@Column(name="cidade", length = 150, nullable = false)
	private String cidade;
	
	@NotBlank
	@Size(max = 12)
	@Column(name="cep", length = 12, nullable = false)
	private String cep;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
}
