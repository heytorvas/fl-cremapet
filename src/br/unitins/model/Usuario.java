package br.unitins.model;

public class Usuario extends Pessoa implements Cloneable {
	
	private Perfil perfil;
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
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
}


