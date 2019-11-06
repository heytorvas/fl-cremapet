package br.unitins.controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.unitins.application.Util;
import br.unitins.dao.DAO;
import br.unitins.dao.UsuarioDAO;
import br.unitins.model.Perfil;
import br.unitins.model.Sexo;
import br.unitins.model.Usuario;

@Named
@ViewScoped
public class UsuarioController implements Serializable{

	private static final long serialVersionUID = -1252416557438065646L;
	
	private Usuario usuario;
	private List<Usuario> listaUsuario;
	
	public List<Usuario> getListaUsuario() {
		if (listaUsuario == null) {
			DAO<Usuario> dao = new UsuarioDAO();
			listaUsuario = dao.findAll();
			if (listaUsuario == null)
				listaUsuario = new ArrayList<Usuario>();
		} 
		return listaUsuario;
	}
	
	public void incluir() {
		if (validarDados()) {
			DAO<Usuario> dao = new UsuarioDAO();
			// faz a inclusao no banco de dados
			try {
//				String hashSenha = Util.hashSHA256(getUsuario().getSenha());
//				getUsuario().setSenha(hashSenha);
				
				getUsuario().setSenha(Util.hashSHA256(getUsuario().getSenha()));
				
				dao.create(getUsuario());
				dao.getConnection().commit();
				Util.addMessageInfo("Inclus�o realizada com sucesso.");
				limpar();
				listaUsuario = null;
			} catch (SQLException e) {
				dao.rollbackConnection();
				dao.closeConnection();
				Util.addMessageInfo("Erro ao incluir o Usu�rio no Banco de Dados.");
				e.printStackTrace();
			}
		}
	}
	
	public void alterar() {
		if (validarDados()) {
			DAO<Usuario> dao = new UsuarioDAO();
			// faz a alteracao no banco de dados
			try {
				// gerando um hash da senha
				getUsuario().setSenha(Util.hashSHA256(getUsuario().getSenha()));
				dao.update(getUsuario());
				dao.getConnection().commit();
				Util.addMessageInfo("Altera��o realizada com sucesso.");
				limpar();
				listaUsuario = null;
			} catch (SQLException e) {
				dao.rollbackConnection();
				dao.closeConnection();
				Util.addMessageInfo("Erro ao alterar o Usu�rio no Banco de Dados.");
				e.printStackTrace();
			}
				
		}
	}
	
	public void excluir() {
		if (excluir(getUsuario()))
			limpar();
	}
	
	public boolean excluir(Usuario usuario) {
		DAO<Usuario> dao = new UsuarioDAO();
		// faz a exclusao no banco de dados
		try {
			dao.delete(getUsuario().getId());
			dao.getConnection().commit();
			Util.addMessageInfo("Exclus�o realizada com sucesso.");
			return true;
		} catch (SQLException e) {
			dao.rollbackConnection();
			Util.addMessageInfo("Erro ao excluir o Produto no Banco de Dados.");
			e.printStackTrace();
			return false;
		} finally {
			dao.closeConnection();
		}
	}
	
	private boolean validarDados() {
//		if (getUsuario().getSenha().isBlank()) {
//			Util.addMessageWarn("O campo senha deve ser informado.");
//			return false;
//		}
		if (getUsuario().getSenha() == null || 
				getUsuario().getSenha().trim().equals("") ) {
			Util.addMessageError("O campo senha deve ser informado.");
			return false;
		}
		return true;
	}
	
	public Usuario getUsuario() {
		if (usuario == null) {
			usuario = new Usuario();
			//usuario.setTelefone(new Telefone());
		}
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void limpar() {
		usuario = null;
	}
	
	public Perfil[] getListaPerfil() {
		return Perfil.values();
	}
	
	public Sexo[] getListaSexo() {
		return Sexo.values();
	}
}
