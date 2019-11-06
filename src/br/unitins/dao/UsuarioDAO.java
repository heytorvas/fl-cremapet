package br.unitins.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.unitins.model.Usuario;

public class UsuarioDAO extends DAO<Usuario>{
	
	public UsuarioDAO(Connection conn) {
		super(conn);
	}
	
	public UsuarioDAO() {
		super(null);
	}

	@Override
	public void create(Usuario usuario) throws SQLException {
		Connection  conn = getConnection();
		
		PreparedStatement stat = conn.prepareStatement(
				"INSERT INTO " +
			    "public.usuario " +
			    " (nome, sexo, email, senha, perfil, salario) " +
				"VALUES " +
			    " (?, ?, ?, ?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);
		
		stat.setString(1, usuario.getNome());
		stat.setInt(2, usuario.getSexo().getValue());
		stat.setString(3, usuario.getEmail());
		stat.setString(4, usuario.getSenha());
		stat.setInt(5, usuario.getPerfil().getValue());
		stat.setDouble(6, usuario.getSalario());
		
		stat.execute();
		
		//ResultSet rs = stat.getGeneratedKeys();
	}

	@Override
	public void update(Usuario usuario) throws SQLException {
		Connection  conn = getConnection();
		
		PreparedStatement stat = conn.prepareStatement(
				"UPDATE public.usuario SET " +
						" nome = ?, " +
					    " sexo = ?, " +
					    " email = ?, " +
					    " senha = ?, " +
					    " perfil = ? " +
					    " salario = ? " +
						"WHERE " +
					    " id = ? ");
		
		stat.setString(1, usuario.getNome());
		stat.setInt(2, usuario.getSexo().getValue());
		stat.setString(3, usuario.getEmail());
		stat.setString(4, usuario.getSenha());
		stat.setInt(5, usuario.getPerfil().getValue());
		stat.setDouble(6, usuario.getSalario());
		stat.setInt(7, usuario.getId());
		
		stat.execute();
		
	}

	@Override
	public void delete(int id) throws SQLException {

		Connection  conn = getConnection();
//		// deletando o telefone (pq possui um relacionamento de fk)
//		// passando o conn para manter a mesma transacao
//		TelefoneDAO dao = new TelefoneDAO(conn);
//		// telefone tem um relecionamento 1 pra 1, ou seja, o id do usuario eh o mesmo do telefone.
//		dao.delete(id);
		
		// deletando o usuario
		PreparedStatement stat = conn.prepareStatement(
				"DELETE FROM public.usuario WHERE id = ?");
		stat.setInt(1, id);
		
		stat.execute();
		
	}

	@Override
	public List<Usuario> findAll() {
		Connection conn = getConnection();
		if (conn == null) 
			return null;
		
		try {
			PreparedStatement stat = conn.prepareStatement(
					"SELECT " +
					"  id, " +
					"  nome, " +
					"  sexo, " +
					"  email, " +
					"  senha, " +
					"  perfil, " +	
					"  salario " +
					"FROM " +
					"  public.usuario ");
			ResultSet rs = stat.executeQuery();
			
			List<Usuario> listaUsuario = new ArrayList<Usuario>();
			
			while(rs.next()) {
				Usuario usuario = new Usuario();
				stat.setInt(1, usuario.getId());
				stat.setString(2, usuario.getNome());
				stat.setInt(3, usuario.getSexo().getValue());
				stat.setString(4, usuario.getEmail());
				stat.setString(5, usuario.getSenha());
				stat.setInt(6, usuario.getPerfil().getValue());
				stat.setDouble(7, usuario.getSalario());
				
				listaUsuario.add(usuario);
			}
			
			if (listaUsuario.isEmpty())
				return null;
			return listaUsuario;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Usuario findId(Integer id) {
		Connection conn = getConnection();
		if (conn == null) 
			return null;
		
		try {
			PreparedStatement stat = conn.prepareStatement(
					"SELECT " +
					"  id, " +
					"  nome, " +
					"  sexo, " +
					"  email, " +
					"  senha, " +
					"  perfil, " +	
					"  salario " +
					"FROM " +
					"  public.usuario ");
			
			stat.setInt(1, id);
			
			ResultSet rs = stat.executeQuery();
			
			Usuario usuario = null;
			
			if(rs.next()) {
				usuario = new Usuario();
				stat.setInt(1, usuario.getId());
				stat.setString(2, usuario.getNome());
				stat.setInt(3, usuario.getSexo().getValue());
				stat.setString(4, usuario.getEmail());
				stat.setString(5, usuario.getSenha());
				stat.setInt(6, usuario.getPerfil().getValue());
				stat.setDouble(7, usuario.getSalario());
				
//				TelefoneDAO dao = new TelefoneDAO(conn);
//				usuario.setTelefone(dao.findById(usuario.getId()));
//				// caso o retorno do telefone seja nulo, instanciar um telefone
//				if (usuario.getTelefone() == null)
//					usuario.setTelefone(new Telefone());
				
			}
			
			return usuario;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
