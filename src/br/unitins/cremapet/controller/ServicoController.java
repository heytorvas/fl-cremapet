package br.unitins.cremapet.controller;

import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.cremapet.application.Util;
import br.unitins.cremapet.dao.DAO;
import br.unitins.cremapet.dao.ServicoDAO;
import br.unitins.cremapet.model.Servico;

@Named
@ViewScoped
public class ServicoController implements Serializable {

	private static final long serialVersionUID = 1304356328800728020L;

	private Servico servico;

	public ServicoController() {
		Flash flash = FacesContext.
				getCurrentInstance().
				getExternalContext().getFlash();
		flash.keep("produtoFlash");
		servico = (Servico) flash.get("servicoFlash");
	}

	public void incluir() {
		DAO<Servico> dao = new ServicoDAO();
		// faz a inclusao no banco de dados
		try {
			dao.create(getServico());
			dao.getConnection().commit();
			Util.addMessageInfo("Inclusão realizada com sucesso.");
			limpar();
		} catch (SQLException e) {
			dao.rollbackConnection();
			dao.closeConnection();
			Util.addMessageInfo("Erro ao incluir o Produto no Banco de Dados.");
			e.printStackTrace();
		}
	}

	public void alterar() {
		DAO<Servico> dao = new ServicoDAO();
		// faz a alteracao no banco de dados
		try {
			dao.update(getServico());
			dao.getConnection().commit();
			Util.addMessageInfo("Alteração realizada com sucesso.");
			limpar();
		} catch (SQLException e) {
			dao.rollbackConnection();
			dao.closeConnection();
			Util.addMessageInfo("Erro ao alterar o Usuário no Banco de Dados.");
			e.printStackTrace();
		}
	}

	public void excluir() {
		DAO<Servico> dao = new ServicoDAO();
		// faz a exclusao no banco de dados
		try {
			dao.delete(getServico().getId());
			dao.getConnection().commit();
			Util.addMessageInfo("Exclusão realizada com sucesso.");
			limpar();
		} catch (SQLException e) {
			dao.rollbackConnection();
			Util.addMessageInfo("Erro ao excluir o Produto no Banco de Dados.");
			e.printStackTrace();
		} finally {
			dao.closeConnection();
		}
	}

	public Servico getServico() {
		if (servico == null) {
			servico = new Servico();
		}
		return servico;
	}

	public void setProduto(Servico servico) {
		this.servico = servico;
	}

	public void limpar() {
		servico = null;
	}

}
