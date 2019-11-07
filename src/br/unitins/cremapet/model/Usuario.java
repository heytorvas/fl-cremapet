package br.unitins.cremapet.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Usuario implements Cloneable {

	private Integer id;

	@NotEmpty(message = "O campo Nome n„o pode ser vazio")
	@Size(max = 60, message = "O campo Nome deve conter no m·ximo 60 caracteres")
	private String nome;

	@Email
	private String login;

	@Size(min = 6, max = 30, message = "A senha deve conter entre 6 e 30 caracteres")
	private String senha;

	private Perfil perfil;
	
	private Sexo sexo;

	public Usuario() {
		super();
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Usuario(Integer id,
			@NotEmpty(message = "O campo Nome n√£o pode ser vazio") @Size(max = 60, message = "O campo Nome deve conter no m√°ximo 60 caracteres") String nome,
			@Email String login,
			@Size(min = 6, max = 30, message = "A senha deve conter entre 6 e 30 caracteres") String senha,
			Perfil perfil, Sexo sexo) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
		this.sexo = sexo;
	}
	
	@Override
	public Usuario clone() {
		try {
			return (Usuario) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			System.out.println("Erro ao clonar.");
		}
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
