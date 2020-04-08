package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	private static Connection conexao = null;
	
	public static Connection getConnection() {
		if (conexao == null) {
			try {
				Properties prop = loadProperties();
				String url = prop.getProperty("dburl");
				conexao = DriverManager.getConnection(url, prop);
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conexao;
	}
	
	public static void closeConnection() {
		if (conexao != null) {
			try {
				conexao.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.propriedades")) {
			Properties prop = new Properties();
			prop.load(fs);
			return prop;
		}
		catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closeStatement(Statement comando) {
		if (comando != null) {
			try {
				comando.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet resultado) {
		if (resultado != null) {
			try {
				resultado.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

}
