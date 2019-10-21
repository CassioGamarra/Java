/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import model.Conexao;

/**
 *
 * @author cassio
 */
public class TesteConexao {
    public static void main(String[] args) throws SQLException {
        Conexao conexao = Conexao.getInstance();
        
        conexao.conectarBanco();
    }
}
