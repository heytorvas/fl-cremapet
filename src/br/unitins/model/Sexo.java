package br.unitins.model;

public enum Sexo {
	
	MASCULINO(1, "Masculino"),
	FEMININO(2, "Feminino");
	
	private int value;
	private String label;
	
	Sexo(int value, String label) {
		this.value = value;
		this.label = label;
	}

	public int getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}
	
	public static Perfil valueOf(int value) {
		
		for (Perfil perfil : Perfil.values()) {
			if (perfil.getValue() == value) 
				return perfil;
		}
		return null;
	}
}
