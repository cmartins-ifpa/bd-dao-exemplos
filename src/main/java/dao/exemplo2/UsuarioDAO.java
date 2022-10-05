package dao.exemplo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements DAO<Usuario> {

	public UsuarioDAO() {}
	
	@Override
	public Usuario findById(long id) {
		Usuario user = null;
		Connection conn;
		try {
			conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Usuario WHERE id = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				user = new Usuario();
				user.setId(rs.getLong("id"));
				user.setNome(rs.getString("nome"));
				user.setEmail(rs.getString("email"));
				user.setSenha(rs.getString("senha"));
				user.setDataInclusao(rs.getDate("dataInclusao"));

			}
		} catch (SQLException e) {
			// tratamento da exceção
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<Usuario> findAll() {
		List<Usuario> listaUsers = new ArrayList<Usuario>();
		Usuario user = null;
		Connection conn;
		try {
			conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Usuario");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user = new Usuario();
				user.setId(rs.getLong("id"));
				user.setNome(rs.getString("nome"));
				user.setEmail(rs.getString("email"));
				user.setSenha(rs.getString("senha"));
				user.setDataInclusao(rs.getDate("dataInclusao"));
				listaUsers.add(user);
			}
		} catch (SQLException e) {
			// tratamento da exceção
			e.printStackTrace();
		}
		return listaUsers;
	}

	@Override
	public void insert(Usuario user) {
		Connection conn;
		try {
			conn = ds.getConnection();
			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO Usuario "
									+ "	( NOME ,EMAIL,SENHA,DATAINCLUSAO)" 
									+ " VALUES (?,?,?,?)");
			stmt.setString(1, user.getNome());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getSenha());
			stmt.setDate(4, new java.sql.Date(user.getDataInclusao().getTime()));
			int contUp = stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			// tratamento da exceção
			e.printStackTrace();
		}
	}

	@Override
	public void update(Usuario user) {
		Connection conn;
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false); // inicia uma transação
			PreparedStatement stmt = conn.prepareStatement("UPDATE Usuario " 
							+ "  SET NOME = ?, " + " EMAIL= ?,"
							+ "      SENHA= ?," + " DATAINCLUSAO=?" 
							+ "  WHERE ID = ?");
			stmt.setString(1, user.getNome());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getSenha());
			stmt.setDate(4, new java.sql.Date(user.getDataInclusao().getTime()));
			stmt.setLong(5, user.getId());

			int contUp = stmt.executeUpdate();
			conn.commit(); // efetiva a transação
			stmt.close();
		} catch (SQLException e) {
			// tratamento da exceção
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Usuario user) {
		Connection conn;
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false); // inicia uma transação
			PreparedStatement stmt = conn.prepareStatement
					("DELETE FROM Usuario " + "  WHERE ID = ?");
			stmt.setLong(1, user.getId());
			int contUp = stmt.executeUpdate();
			conn.commit(); // efetiva a transação
			stmt.close();
		} catch (SQLException e) {
			// tratamento da exceção
			e.printStackTrace();
		}
	}

	 
  
}
