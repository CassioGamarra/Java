package br.com.cassiogamarra.projetofinal.catracas;

import br.com.cassiogamarra.projetofinal.database.ConectarDB;
import br.com.cassiogamarra.projetofinal.gui.FrameCatracas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CatracaVirtual{
    
    public static void entrada(FrameCatracas frame) throws SQLException {
        
        long codigo = Long.parseLong(frame.getCampoConsulta().getText());
        
        Connection conectar = ConectarDB.conectar();
        String sql = "SELECT situacao FROM catraca WHERE codigo = "+codigo;
        int status = 0;
        try{
            PreparedStatement stmt = conectar.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                status = Integer.parseInt(consulta.getString("situacao"));
            }
            if(status == 1){
                JOptionPane.showMessageDialog(null, "ENTRADA DUPLA!!!");
            }
             else{
                //Procura o nome da pessoa
                sql = "SELECT * FROM usuario WHERE codigo = "+codigo;
                String nome = "";
                int situacao = 0;
                try{
                    stmt = conectar.prepareStatement(sql);
                    consulta = stmt.executeQuery(sql);
                    while(consulta.next()){
                        nome = consulta.getString("nome");
                        situacao = consulta.getInt("situacao");
                    }
                    if(situacao == 0){
                        JOptionPane.showMessageDialog(null, "PESSOA INATIVA!!!");
                    }
                    else{
                        //Faz a entrada da pessoa
                        sql = "INSERT INTO catraca(codigo, situacao)VALUES(?,?)";
                        try{
                            stmt = conectar.prepareStatement(sql);
                            stmt.setLong(1, codigo);
                            stmt.setInt(2, 1);
                            stmt.execute();
                            JOptionPane.showMessageDialog(null, "BEM VINDO: "+nome);
                        }

                        catch(SQLException e){
                            throw new RuntimeException(e);
                        }
                    }
                }
                catch(SQLException e){
                   throw new RuntimeException(e);
                }
                
                
                
            }
        }
        catch(SQLException e){
           throw new RuntimeException(e);
        }
        
       
        
    }
    public static void saida(FrameCatracas frame) {
        
    }
}
