package modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import modelo.dao.DepartamentoDao;
import modelo.entidades.Departamento;

public class DepartamentoDaoJDBC implements DepartamentoDao {

	private Connection conexao;

	public DepartamentoDaoJDBC(Connection conexao) {
			this.conexao = conexao;
		}

	@Override
	public Departamento findById(Integer id) {
		PreparedStatement comando = null;
		ResultSet resultado = null;
		try {
			comando = conexao.prepareStatement("SELECT * FROM department WHERE Id = ?");
			comando.setInt(1, id);
			resultado = comando.executeQuery();

			if (resultado.next()) {
				Departamento obj = new Departamento();
				obj.setId(resultado.getInt("Id"));
				obj.setNome(resultado.getString("Name"));
				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(comando);
			DB.closeResultSet(resultado);
		}
	}

	@Override
	public List<Departamento> findAll() {
		PreparedStatement comando = null;
		ResultSet resultado = null;
		try {
			comando = conexao.prepareStatement("SELECT * FROM department ORDER BY Name");
			resultado = comando.executeQuery();

			List<Departamento> licomando = new ArrayList<>();

			while (resultado.next()) {
				Departamento obj = new Departamento();
				obj.setId(resultado.getInt("Id"));
				obj.setNome(resultado.getString("Name"));
				licomando.add(obj);
			}
			return licomando;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(comando);
			DB.closeResultSet(resultado);
		}
	}

	@Override
	public void insert(Departamento obj) {
		PreparedStatement comando = null;
		try {
			comando = conexao.prepareStatement("INSERT INTO department " + "(Name) " + "VALUES " + "(?)",
					Statement.RETURN_GENERATED_KEYS);

			comando.setString(1, obj.getNome());

			int linhasAfetadas = comando.executeUpdate();

			if (linhasAfetadas > 0) {
				ResultSet resultado = comando.getGeneratedKeys();
				if (resultado.next()) {
					int id = resultado.getInt(1);
					obj.setId(id);
				}
			} else {
				throw new DbException("Erro inesperado! Não há linhas afetadas!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(comando);
		}
	}

	@Override
	public void update(Departamento obj) {
		PreparedStatement comando = null;
		try {
			comando = conexao.prepareStatement("UPDATE department " + "SET Name = ? " + "WHERE Id = ?");

			comando.setString(1, obj.getNome());
			comando.setInt(2, obj.getId());

			comando.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(comando);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement comando = null;
		try {
			comando = conexao.prepareStatement("DELETE FROM department WHERE Id = ?");

			comando.setInt(1, id);
			comando.executeUpdate();
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closeStatement(comando);
		}
	}
}