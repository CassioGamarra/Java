package br.com.cassiogamarra.projetofinal.database;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Classe para testar o banco de dados
 * @author Gnomo
 */
public class TestarConexao {
    public static void main(String[] args) throws SQLException{
        Connection conectar = ConectarDB.conectar();
        conectar.close();
    }
}
