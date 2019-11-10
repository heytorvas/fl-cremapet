package br.unitins.cremapet.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.cremapet.application.Session;
import br.unitins.cremapet.model.ItemVenda;
import br.unitins.cremapet.model.Usuario;
import br.unitins.cremapet.model.Venda;

@Named
@ViewScoped
public class CarrinhoController implements Serializable {

	private static final long serialVersionUID = -1229885960428245332L;

	private Venda venda;

	public Venda getVenda() {
		if (venda == null)
			venda = new Venda();

		// obtendo o carrinho da sessao
		List<ItemVenda> carrinho = (ArrayList<ItemVenda>) Session.getInstance().getAttribute("carrinho");

		// adicionando os itens do carrinho na venda
		if (carrinho == null)
			carrinho = new ArrayList<ItemVenda>();

		venda.setListaItemVenda(carrinho);
		return venda;
	}

	public void remover(int idServico) {
		// obtendo o carrinho da sessao
		List<ItemVenda> carrinho = (List<ItemVenda>) Session.getInstance().getAttribute("carrinho");

		// removendo o item do carrinho
		for (ItemVenda itemVenda : carrinho) {

			if (itemVenda.getServico().getId().equals(idServico)) {
				carrinho.remove(itemVenda);
				return;
			}

		}
	}

	public void finalizar() {
//		// Definindo o usuario que está logado com o cliente
//		Usuario user = (Usuario) Session.getInstance().getAttribute("usuarioLogado");
//		getVenda().setCliente(user.getNome());
//
//		getVenda().setUsuario((Usuario) Session.getInstance().getAttribute("usuarioLogado"));
//		VendaDAO dao = new VendaDAO();
//		dao.create(getVenda());
//
//		// Finalizando venda e limpando o carrinho
//		List<ItemVenda> carrinho = (List<ItemVenda>) Session.getInstance().getAttribute("carrinho");
//		carrinho.clear();
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

}
