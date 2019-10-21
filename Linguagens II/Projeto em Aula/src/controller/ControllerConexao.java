/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import model.Conexao;
import view.ViewConfig;
import view.ViewPrincipal;


/**
 *
 * @author cassio
 */
public class ControllerConexao {
    public ControllerConexao(){}
    
    public void conectar(ViewConfig view) throws SQLException{
        Conexao conexao = Conexao.getInstance();
        conexao.setIP(view.getFieldIP().getText());
        conexao.setUser(view.getFieldUser().getText());
        conexao.setPassword(view.getFieldPassword().getText());
        conexao.conectarBanco();
        
        ViewPrincipal viewP = new ViewPrincipal();
        viewP.setLocationRelativeTo(null);
        viewP.setVisible(true);
    }
}
