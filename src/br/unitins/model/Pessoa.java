package br.unitins.model;

public class Pessoa {
	private Integer id;
	private String nome;
	private Sexo sexo;
	private String email;
	private String senha;
	private Endereco endereco;
	
	public Pessoa() {
		
	}
	public Pessoa(Integer id, Sexo sexo, String nome, String email, String senha, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.setSexo(sexo);
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
