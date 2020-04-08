package aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class Programa {

	public static void main(String[] args) {

		Connection conexao = null;
		PreparedStatement comando = null;
		
		try {
			conexao = DB.getConnection();
			comando = conexao.prepareStatement
					("DELETE FROM department " 
					+ "WHERE (Id = ?)");

			comando.setInt(1, 5);

			int linhasAfetadas = comando.executeUpdate();
			System.out.println("Feito! linhas afetada: " + linhasAfetadas);
		}
		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}
		finally {
			DB.closeStatement(comando);
			DB.closeConnection();
		}
	}
}
