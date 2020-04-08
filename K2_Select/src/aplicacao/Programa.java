package aplicacao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Programa {

	public static void main(String[] args) {

		Connection conexao = null;
		Statement comando = null;
		ResultSet resultado = null;
		
		try {
			conexao = DB.getConnection();
			comando = conexao.createStatement();
			resultado = comando.executeQuery("select * from department");
			
			while (resultado.next()) {
				System.out.println(resultado.getInt("Id") + " - " + resultado.getString("Name"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(resultado);
			DB.closeStatement(comando);
			DB.closeConnection();
		}
		
	}
}
