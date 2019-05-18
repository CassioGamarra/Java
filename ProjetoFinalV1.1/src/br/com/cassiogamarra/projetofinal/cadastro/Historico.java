
package br.com.cassiogamarra.projetofinal.cadastro;

import br.com.cassiogamarra.projetofinal.database.ConectarDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Historico {
    public Historico(){
    }
    
    public static void historico() throws SQLException{
        Connection conectar = ConectarDB.conectar();
        String sql = "SELECT * FROM usuario WHERE situacao = 0";
        String mensagem = "";
        try{
            PreparedStatement stmt = conectar.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                String nome = consulta.getString("nome");
                String codigo = consulta.getString("codigo");
                if(mensagem.equals("")){
                    mensagem = "Nome: "+nome+
                            "\nCódigo: "+codigo;
                }
                else{
                    mensagem = mensagem + "\nNome: "+nome+
                            "\nCódigo: "+codigo;
                }
                
            }
            JOptionPane.showMessageDialog(null, mensagem, "HISTÓRICO EXCLUIDOS", JOptionPane.PLAIN_MESSAGE);
        }
        catch(SQLException e){
           throw new RuntimeException(e);
        }
    }
}
