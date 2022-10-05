package dao.exemplo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DataSource {
		// parametros de configuração para acesso a um banco H2
		String driverClassName = "org.h2.Driver";
		String connectionUrl = "jdbc:h2:tcp://localhost/~/test";
		String dbUser = "sa";
		String dbPwd = "";
		// conexao ao banco 
		Connection conn = null;
		
		private static DataSource ds = null;

		private DataSource() {
			try {
				Class.forName(driverClassName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		/**
		 * Método de criação de uma única instância de DS (Usa o pattern Singleton)
		 * 
		 * @return DataSource
		 */
		public static DataSource getInstance() {
			if (ds == null) {
				ds = new DataSource();
			}
			return ds;
		}		
		
		public Connection getConnection() throws SQLException {	
			if (conn == null)
			    conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
			return conn;
		}

		public void closeConnection() {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
				conn = null;
			}
		}
}
