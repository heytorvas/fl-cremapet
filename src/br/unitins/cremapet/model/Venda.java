package br.unitins.cremapet.model;

import java.time.LocalDate;
import java.util.List;

public class Venda {
	
	private Integer id;
	private LocalDate data;
	private Cliente cliente;
	private Usuario usuario;
	private List<ItemVenda> listaItemVenda;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<ItemVenda> getListaItemVenda() {
		return listaItemVenda;
	}
	public void setListaItemVenda(List<ItemVenda> listaItemVenda) {
		this.listaItemVenda = listaItemVenda;
	}
	
	
}
