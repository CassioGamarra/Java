package br.com.cassiogamarra.projetofinal.cadastro;

import br.com.cassiogamarra.projetofinal.database.ConectarDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * Classe para exibir o histórico de ativos e excluidos
 * @author Gnomo
 */

public class Historico {
    public Historico(){}
    
    ConectarDB conectar = new ConectarDB();
    
    public void excluidos() throws SQLException{
        String sql = "SELECT * FROM usuario WHERE situacao = 0";
        String mensagem = "";
        try{
            PreparedStatement stmt = conectar.conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                String nome = consulta.getString("nome");
                String codigo = consulta.getString("codigo");
                if(mensagem.equals("")){
                    mensagem = "Código: "+codigo+
                            " |  Nome: "+nome+"\n";
                }
                else{
                    mensagem = mensagem + "\nCódigo: "+codigo+
                            " |  Nome: "+nome+"\n";
                } 
            }
            if(mensagem.equals("")){
                JOptionPane.showMessageDialog(null, "SEM HISTÓRICO",
                        "HISTÓRICO EXCLUIDOS", JOptionPane.PLAIN_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, new JTextArea(mensagem),
                        "HISTÓRICO EXCLUIDOS", JOptionPane.PLAIN_MESSAGE);
            }
        }
        catch(SQLException e){
           throw new RuntimeException(e);
        }
    }
    public void ativos() throws SQLException{
        String sql = "SELECT * FROM usuario WHERE situacao = 1";
        String mensagem = "";
        try{
            PreparedStatement stmt = conectar.conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                String nome = consulta.getString("nome");
                String codigo = consulta.getString("codigo");
                if(mensagem.equals("")){
                    mensagem = "Código: "+codigo+
                            " |  Nome: "+nome+"\n";
                }
                else{
                    mensagem = mensagem + "\nCódigo: "+codigo+
                            " |  Nome: "+nome+"\n";
                }
            }
            if(mensagem.equals("")){
                JOptionPane.showMessageDialog(null, "SEM USUÁRIOS ATIVOS",
                        "USUÁRIOS ATIVOS", JOptionPane.PLAIN_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, new JTextArea(mensagem),
                        "USUÁRIOS ATIVOS", JOptionPane.PLAIN_MESSAGE);
            }
            conectar.conectar().close();
        }
        catch(SQLException e){
           throw new RuntimeException(e);
        }
    }
}
