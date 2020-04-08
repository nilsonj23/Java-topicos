package aplicacao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Programa {

	public static void main(String[] args) {

		Connection conexao = null;
		Statement comando = null;
		
		try {
			conexao = DB.getConnection();
			conexao.setAutoCommit(false);
			comando = conexao.createStatement();

			int linha1 = comando.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
			/*
			int x = 1;
			if (x < 2) {
				throw new SQLException("Fake error");
			}
			*/
			int linha2 = comando.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");
			
			conexao.commit();
			
			System.out.println("linha 1 = " + linha1);
			System.out.println("linha 2 = " + linha2);
		}
		catch (SQLException e) {
			try {
				conexao.rollback();
				throw new DbException("Transação rollback! Causado por: " + e.getMessage());
			} 
			catch (SQLException e1) {
				throw new DbException("Erro na tentativa de rollback! Causado por: " + e1.getMessage());
			} 
		}
		finally {
			DB.closeStatement(comando);
			DB.closeConnection();
		}
	}
}
