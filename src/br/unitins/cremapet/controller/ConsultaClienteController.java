package br.unitins.cremapet.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.cremapet.dao.ClienteDAO;
import br.unitins.cremapet.model.Cliente;

@Named
@ViewScoped
public class ConsultaClienteController implements Serializable{

	private static final long serialVersionUID = -2133044218455660681L;
	
	private String nome;
	
	private List<Cliente> listaCliente = null;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cliente> getListaCliente() {
		if (listaCliente == null) {
			ClienteDAO dao = new ClienteDAO();
			listaCliente = dao.findByNome(getNome());
			if (listaCliente == null) {
				listaCliente = new ArrayList<Cliente>();
			}
			dao.closeConnection();
		}
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
	
	public void pesquisar() {
		listaCliente = null;
	}

}
