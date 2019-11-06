package br.unitins.model;

public class Usuario extends Pessoa implements Cloneable {
	private Double salario;

	public Usuario() {
		
	}
	public Usuario(Double salario) {
		super();
		this.salario = salario;
	}
	
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
}


