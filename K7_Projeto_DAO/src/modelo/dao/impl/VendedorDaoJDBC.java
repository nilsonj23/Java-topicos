package modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import modelo.dao.VendedorDao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class VendedorDaoJDBC implements VendedorDao {
	
	private Connection conexao;
	
	// CONSTRUTOR
	public VendedorDaoJDBC(Connection conexao) {
		this.conexao = conexao;
	}

	// METODOS
	@Override
	public void insert(Vendedor obj) {
		PreparedStatement comando = null;
		try {
			comando = conexao.prepareStatement(		
						"INSERT INTO seller "
						+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
						+ "VALUES "
						+ " (?, ?, ?, ?, ?)",
						Statement.RETURN_GENERATED_KEYS);
			
			comando.setString(1, obj.getNome());
			comando.setString(2, obj.getEmail());
			comando.setDate(3, new java.sql.Date(obj.getDataNasc().getTime()));
			comando.setDouble(4, obj.getSalarioBase());
			comando.setInt(5, obj.getDepartamento().getId());
		
			int linhasAfetadas = comando.executeUpdate();
			if (linhasAfetadas > 0) {
				ResultSet resultado = comando.getGeneratedKeys();
				if (resultado.next()) {
					int id = resultado.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(resultado);
			}
			else {
				throw new DbException("Erro inesperado! Nenhuma linha afetada!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(comando);
		}
	}

	@Override
	public void update(Vendedor obj) {
		PreparedStatement comando = null;
		try {
			comando = conexao.prepareStatement(		
					"UPDATE seller "
					+ "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? "
					+ "WHERE Id = ?");
			
			comando.setString(1, obj.getNome());
			comando.setString(2, obj.getEmail());
			comando.setDate(3, new java.sql.Date(obj.getDataNasc().getTime()));
			comando.setDouble(4, obj.getSalarioBase());
			comando.setInt(5, obj.getDepartamento().getId());
			comando.setInt(6, obj.getId());
		
			comando.executeUpdate();	
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(comando);
		}		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement comando = null;
		try {
			comando = conexao.prepareStatement("DELETE FROM seller WHERE Id = ?");
			
			comando.setInt(1, id);
			comando.executeUpdate();	
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(comando);
		}			
	}

	@Override
	public Vendedor findById(Integer id) {
		PreparedStatement comando = null;
		ResultSet resultado = null;
		try {
			comando = conexao.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?");
			
			comando.setInt(1, id);
			resultado = comando.executeQuery();
			
			if (resultado.next()) {
				Departamento dep = instanciacaoDepartamento(resultado);
				Vendedor obj = instaciacaoVendedor(resultado, dep);
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(comando);
			DB.closeResultSet(resultado);
		}
	}

	private Vendedor instaciacaoVendedor(ResultSet resultado, Departamento dep) throws SQLException {
		Vendedor obj = new Vendedor();
		obj.setId(resultado.getInt("Id"));
		obj.setNome(resultado.getString("Name"));
		obj.setEmail(resultado.getString("Email"));
		obj.setSalarioBase(resultado.getDouble("BaseSalary"));
		obj.setDataNasc(resultado.getDate("BirthDate"));
		obj.setDepartamento(dep);		
		return obj;
	}

	private Departamento instanciacaoDepartamento(ResultSet resultado) throws SQLException {
		Departamento dep = new Departamento();
		// O nome da coluna na qual se quer o dado
		dep.setId(resultado.getInt("DepartmentId"));
		dep.setNome(resultado.getString("DepName"));		
		return dep;
	}

	@Override
	public List<Vendedor> findAll() {
		PreparedStatement comando = null;
		ResultSet resultado = null;
		try {
			comando = conexao.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "ORDER BY Name");
			
			resultado = comando.executeQuery();
			
			List<Vendedor> lista = new ArrayList<>();
			Map<Integer, Departamento> map = new HashMap<>();
			
			while (resultado.next()) {
				Departamento dep = map.get(resultado.getInt("DepartmentId"));

				if (dep == null) {
					dep = instanciacaoDepartamento(resultado);
					map.put(resultado.getInt("DepartmentId"), dep);
				}
				Vendedor obj = instaciacaoVendedor(resultado, dep);
				lista.add(obj);
			}
			return lista;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(comando);
			DB.closeResultSet(resultado);
		}
	}

	@Override
	public List<Vendedor> findByDepartment(Departamento departamento) {
		PreparedStatement comando = null;
		ResultSet resultado = null;
		try {
			comando = conexao.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE DepartmentId = ? "
					+ "ORDER BY Name");
			
			comando.setInt(1, departamento.getId());
			resultado = comando.executeQuery();
			
			List<Vendedor> lista = new ArrayList<>();
			Map<Integer, Departamento> map = new HashMap<>();
			
			while (resultado.next()) {
				Departamento dep = map.get(resultado.getInt("DepartmentId"));

				if (dep == null) {
					dep = instanciacaoDepartamento(resultado);
					map.put(resultado.getInt("DepartmentId"), dep);
				}
				Vendedor obj = instaciacaoVendedor(resultado, dep);
				lista.add(obj);
			}
			return lista;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(comando);
			DB.closeResultSet(resultado);
		}
	}

}
