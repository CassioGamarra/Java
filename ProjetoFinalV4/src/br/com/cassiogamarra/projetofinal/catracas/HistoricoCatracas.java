
package br.com.cassiogamarra.projetofinal.catracas;

import br.com.cassiogamarra.projetofinal.database.ConectarDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class HistoricoCatracas {
    
    public HistoricoCatracas(){
    
    }
    
    public static void historicoEntrada() throws SQLException{
        Connection conectar = ConectarDB.conectar();
        String sql = "SELECT usuario.nome, catraca.codigo, catraca.dataHora FROM usuario, catraca WHERE usuario.codigo = catraca.codigo AND catraca.situacao = 1";
        String mensagem = "";
        try{
            PreparedStatement stmt = conectar.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                String nome = consulta.getString("nome");
                String codigo = consulta.getString("codigo");
                String dataHora = consulta.getString("dataHora");
                if(mensagem.equals("")){
                    mensagem = "Código: "+codigo+
                            " |  Nome: "+nome+" | "+dataHora+"\n";
                }
                else{
                    mensagem = mensagem + "\nCódigo: "+codigo+
                            "  |  Nome: "+nome+" | "+dataHora+"\n";
                }
            }
            
            if(mensagem.equals("")){
                JOptionPane.showMessageDialog(null, "SEM HISTÓRICO",
                        "HISTÓRICO ENTRADA", JOptionPane.PLAIN_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, new JTextArea(mensagem),
                        "HISTÓRICO ENTRADA", JOptionPane.PLAIN_MESSAGE);
            }
        }
        catch(SQLException e){
           throw new RuntimeException(e);
        }
    }
    
    public static void historicoSaida() throws SQLException{
        Connection conectar = ConectarDB.conectar();
        String sql = "SELECT usuario.nome, catraca.codigo, catraca.dataHora FROM usuario, catraca WHERE usuario.codigo = catraca.codigo AND catraca.situacao = 0";
        String mensagem = "";
        try{
            PreparedStatement stmt = conectar.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                String nome = consulta.getString("nome");
                String codigo = consulta.getString("codigo");
                String dataHora = consulta.getString("dataHora");
                if(mensagem.equals("")){
                    mensagem = "Código: "+codigo+
                            " |  Nome: "+nome+" | "+dataHora+"\n";
                }
                else{
                    mensagem = mensagem + "\nCódigo: "+codigo+
                            " |  Nome: "+nome+" | "+dataHora+"\n";
                }
            }
            
            if(mensagem.equals("")){
                JOptionPane.showMessageDialog(null, "SEM HISTÓRICO",
                        "HISTÓRICO SAÍDA", JOptionPane.PLAIN_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, new JTextArea(mensagem),
                        "HISTÓRICO SAÍDA", JOptionPane.PLAIN_MESSAGE);
            }
        }
        catch(SQLException e){
           throw new RuntimeException(e);
        }
    }

}
