package br.com.cassiogamarra.projetofinal.cadastro;

import br.com.cassiogamarra.projetofinal.database.ConectarDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Historico {
    public Historico(){
    }
    
    public static void excluidos() throws SQLException{
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
    public static void ativos() throws SQLException{
        Connection conectar = ConectarDB.conectar();
        String sql = "SELECT * FROM usuario WHERE situacao = 1";
        String mensagem = "";
        try{
            PreparedStatement stmt = conectar.prepareStatement(sql);
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
            conectar.close();
        }
        catch(SQLException e){
           throw new RuntimeException(e);
        }
    }
}
