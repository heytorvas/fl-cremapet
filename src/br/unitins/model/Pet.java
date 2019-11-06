package br.unitins.model;

public class Pet implements Cloneable{
	private Integer id;
	private String tipo;
	private String nome;
	private Sexo sexo;
	private Cliente cliente;
	
	public Pet() {
		
	}
	public Pet(Integer id, String tipo, String nome, Sexo sexo, Cliente cliente) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nome = nome;
		this.sexo = sexo;
		this.cliente = cliente;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
