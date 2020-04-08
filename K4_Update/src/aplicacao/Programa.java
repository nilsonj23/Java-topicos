package aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Programa {

	public static void main(String[] args) {

		Connection conexao = null;
		PreparedStatement comando = null;
		
		try {
			conexao = DB.getConnection();
			comando = conexao.prepareStatement
					("UPDATE seller " 
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE (DepartmentId = ?)");

			comando.setDouble(1, 200);
			comando.setInt(2, 2);

			int linhasAfetadas = comando.executeUpdate();
			System.out.println("Feito! linhas afetada: " + linhasAfetadas);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(comando);
			DB.closeConnection();
		}
	}
}
