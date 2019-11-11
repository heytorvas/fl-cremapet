package br.unitins.cremapet.controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.cremapet.application.Session;
import br.unitins.cremapet.application.Util;
import br.unitins.cremapet.dao.ServicoDAO;
import br.unitins.cremapet.dao.VendaDAO;
import br.unitins.cremapet.model.ItemVenda;
import br.unitins.cremapet.model.Servico;
import br.unitins.cremapet.model.Usuario;
import br.unitins.cremapet.model.Venda;

@Named
@ViewScoped
public class CarrinhoController implements Serializable {

	private static final long serialVersionUID = -1229885960428245332L;

	private Venda venda;

	public void adicionar(int id) {
		// pesquisa o servico selecionado
		ServicoDAO dao = new ServicoDAO();
		Servico servico = dao.findById(id);

		// verifica se existe o carrinho na sessao
		if (Session.getInstance().getAttribute("carrinho") == null) {
			// adiciona o carrinho na sessao
			Session.getInstance().setAttribute("carrinho", new ArrayList<ItemVenda>());
		}

		// busca o carrinho da sessao
		List<ItemVenda> carrinho = (List<ItemVenda>) Session.getInstance().getAttribute("carrinho");

		// cria um item de venda
		ItemVenda item = new ItemVenda();
		item.setServico(servico);
		item.setValor(servico.getValor());

		// adiciona o item no objeto de referencia do carrinho
		carrinho.add(item);

		// atualiza o carrinho
		Session.getInstance().setAttribute("carrinho", carrinho);

		Util.addMessageError("Adicionado com Sucesso! ");

	}

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
		// Definindo o usuario que está logado com o cliente
		Usuario user = (Usuario) Session.getInstance().getAttribute("usuarioLogado");
		getVenda().setUsuario(user);

		getVenda().setUsuario((Usuario) Session.getInstance().getAttribute("usuarioLogado"));
		VendaDAO dao = new VendaDAO();
		try {
			dao.create(getVenda());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Finalizando venda e limpando o carrinho
		List<ItemVenda> carrinho = (List<ItemVenda>) Session.getInstance().getAttribute("carrinho");
		carrinho.clear();
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

}
