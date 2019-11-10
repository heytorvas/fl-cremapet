package br.unitins.cremapet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import br.unitins.cremapet.application.Util;
import br.unitins.cremapet.model.ItemVenda;
import br.unitins.cremapet.model.Venda;

public class VendaDAO extends DAO<Venda> {

	public VendaDAO(Connection conn) {
		super(conn);
	}

	@Override
	public void create(Venda venda) throws SQLException {
		
		// verificando se tem uma conexao valida
		if (getConnection() == null) {
			Util.addMessageError("Falha ao conectar ao Banco de Dados.");
		}
		
		PreparedStatement stat = null;
		try {
			stat =	getConnection().prepareStatement("INSERT INTO venda ( "
										+ "  data, "
										+ "  idcliente,"
										+ "  idusuario ) " 
										+ "VALUES ( "
										+ " ?, "
										+ " ?, "
										+ " ? ) ", Statement.RETURN_GENERATED_KEYS);
			stat.setDate(1, Date.valueOf(LocalDate.now()));
			stat.setInt(2, venda.getCliente().getId());
			stat.setInt(3, venda.getUsuario().getId());
			
			stat.executeUpdate();
			final ResultSet rs = stat.getGeneratedKeys();
			rs.next();
			final int lastId = rs.getInt("id");
			
			stat.close();
			
			for (ItemVenda itemVenda : venda.getListaItemVenda()) {
				stat =	getConnection().prepareStatement("INSERT INTO itemvenda ( "
						+ "  valor, "
						+ "  idvenda,"
						+ "  idservico ) " 
						+ "VALUES ( "
						+ " ?, "
						+ " ?, "
						+ " ? ) ");
				stat.setDouble(1, itemVenda.getValor());
				stat.setInt(2, lastId);
				stat.setInt(3, itemVenda.getServico().getId());
				
				stat.execute();
				stat.close();
			}

			
			Util.addMessageError("Venda finalizada com sucesso!");
		} catch (SQLException e) {
			Util.addMessageError("Falha ao incluir.");
			e.printStackTrace();
		} finally {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void update(Venda entity) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Venda> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
