package br.unitins.model;

import java.time.LocalDate;

public class Cliente extends Pessoa implements Cloneable{
	private LocalDate dataNasc;

	public Cliente() {
		
	}
	public Cliente(LocalDate dataNasc) {
		super();
		this.dataNasc = dataNasc;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
	
}
