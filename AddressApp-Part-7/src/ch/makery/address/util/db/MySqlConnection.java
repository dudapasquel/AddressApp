package ch.makery.address.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySqlConnection implements ConnectionFactory {

    private static MySqlConnection conexao;


    private MySqlConnection() {}

    public static MySqlConnection getInstance() {
        if(conexao == null)
            conexao = new MySqlConnection();

        return conexao;
    }


	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/addressapp", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

}
