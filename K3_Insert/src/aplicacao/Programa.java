package aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Programa {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conexao = null;
		PreparedStatement comando = null;
		
		try {
			conexao = DB.getConnection();

			// EXEMPLO 1:
			comando = conexao.prepareStatement
					("INSERT INTO seller " 
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES " + "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			comando.setString(1, "Carl Purple");
			comando.setString(2, "carl@gmail.com");
			comando.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
			comando.setDouble(4, 3000.0);
			comando.setInt(5, 4);

			// EXAMPLE 2:
			//comando = conexao.prepareStatement(
			//		"insert into department (Name) values ('D1'),('D2')",
			//		Statement.RETURN_GENERATED_KEYS);

			int linhasAfetadas = comando.executeUpdate();

			if (linhasAfetadas > 0) {
				ResultSet resultado = comando.getGeneratedKeys();
				while (resultado.next()) {
					int id = resultado.getInt(1);
					System.out.println("Feito! Id: " + id);
				}
			} else {
				System.out.println("Nenhuma linha afetada!");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(comando);
			DB.closeConnection();
		}
	}
}
