package br.com.cassiogamarra.projetofinal.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Classe para conexão com o banco de dados
 * @author Gnomo
 */
public class ConectarDB{
    
    public static Connection conectar() throws SQLException{
        Connection conectar = null;
        try{
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancocatracas","root","");
            return conectar;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possivel conectar");
	}
	return conectar;
    }
}

/* *COMANDO SQL PARA CRIAR O BANCO*
CREATE DATABASE bancocatracas;
USE bancocatracas;
CREATE TABLE usuario(
codigo BIGINT(10) AUTO_INCREMENT,
nome VARCHAR(200),
cpf VARCHAR(20),
telefone VARCHAR(20),
dependentes INT(10),
turma VARCHAR(50),
cargo VARCHAR(50),
observacoes VARCHAR(200),
categoria VARCHAR(30),
situacao TINYINT(1),
PRIMARY KEY (codigo)
);

ALTER TABLE usuario AUTO_INCREMENT = 12000;
*/

/*
Banco externo:
phpmyadmin.umbler.com -> mysql465.umbler.com

mysql465.umbler.com:41890
cassiogamarra
O+f5pl*-O3[Z
*/