package br.com.cassiogamarra.projetofinal.catracas;


import br.com.cassiogamarra.projetofinal.database.BancoDeDados;
import br.com.cassiogamarra.projetofinal.gui.FrameCatracas;
import br.com.cassiogamarra.projetofinal.utilitarios.DataHora;
import br.com.cassiogamarra.projetofinal.utilitarios.Frame;
import br.com.cassiogamarra.projetofinal.utilitarios.Validador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * Classe da catraca automática
 * @author Gamarra
 */
public class CatracaVirtualAutomatica {
    
    BancoDeDados conectar = new BancoDeDados();
    Validador validador = new Validador();
    CatracaVirtual catraca = new CatracaVirtual();
    
    public void catracaAutomatica(FrameCatracas frame){
        if(!validador.validarCodigo(frame.getCampoConsultaAuto().getText())){
            JOptionPane.showMessageDialog(null, "Código inválido!"
                    + "\nO código possui apenas 6 digitos numéricos");
            Frame.limparFrame(frame.getFrameAutomatica());
        }
        else{
            long codigo = Long.parseLong(frame.getCampoConsultaAuto().getText());
            
            String sql = "SELECT situacao FROM catraca WHERE codigo = "+codigo;
            int status = 0;
            String horaAtual = DataHora.recuperarDataHora();
            try{
                PreparedStatement stmt = conectar.conectar().prepareStatement(sql);
                ResultSet consulta = stmt.executeQuery(sql);
                while(consulta.next()){
                    status = Integer.parseInt(consulta.getString("situacao"));
                }
                if(status == 0){
                    sql = "SELECT * FROM usuario WHERE codigo = "+codigo;
                    String nome = "";
                    int situacao = 0;
                    try{
                        stmt = conectar.conectar().prepareStatement(sql);
                        consulta = stmt.executeQuery(sql);
                        while(consulta.next()){
                            nome = consulta.getString("nome");
                            situacao = consulta.getInt("situacao");
                        }
                        if(situacao == 0){
                            JOptionPane.showMessageDialog(null, "PESSOA INATIVA!!!");
                            Frame.limparFrame(frame.getFrameAutomatica());
                        }
                        else{
                            //Faz a entrada da pessoa
                            sql = "INSERT INTO catraca(codigo, dataHora ,situacao)VALUES(?,?,?)";
                            try{
                                stmt = conectar.conectar().prepareStatement(sql);
                                stmt.setLong(1, codigo);
                                stmt.setString(2, horaAtual);
                                stmt.setInt(3, 1);
                                stmt.execute();
                                String mensagem = "BEM VINDO(A): "+nome+"\n"+
                                    "Entrada: "+horaAtual;
                            JOptionPane.showMessageDialog(null, new JTextArea(mensagem),
                                    "ENTRADA", JOptionPane.PLAIN_MESSAGE);
                                Frame.limparFrame(frame.getFrameAutomatica());
                            }

                            catch(SQLException e){
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    catch(SQLException e){
                       throw new RuntimeException(e);
                    }
                    Frame.limparFrame(frame.getFrameAutomatica());
                }
                else{
                    //Procura o nome da pessoa
                    sql = "SELECT usuario.*, catraca.dataHora FROM usuario,"
                            + "catraca WHERE usuario.codigo = "+codigo
                            +" AND catraca.situacao = 1";

                    String nome = "", dataEntrada = "";
                    int situacao = 0;
                    try{
                        stmt = conectar.conectar().prepareStatement(sql);
                        consulta = stmt.executeQuery(sql);

                        while(consulta.next()){
                            nome = consulta.getString("nome");
                            situacao = consulta.getInt("situacao");
                            dataEntrada = consulta.getString("dataHora");
                        }
                        //Se a pessoa já realizou uma saída e está ativa no sistema
                        if(status == 0 && situacao == 1){
                            JOptionPane.showMessageDialog(null, "SAÍDA DUPLA!!!");
                            Frame.limparFrame(frame.getFrameSaida());
                        }
                        //Se a pessoa já foi excluida e já entrou ou se apenas entrou
                        else if((situacao == 0 && status == 1) || (status == 1)){
                            //Faz a saída da pessoa
                            sql = "INSERT INTO catraca(codigo, dataHora ,situacao)VALUES(?,?,?)";
                            try{
                                stmt = conectar.conectar().prepareStatement(sql);
                                stmt.setLong(1, codigo);
                                stmt.setString(2, horaAtual);
                                stmt.setInt(3, 0);
                                stmt.execute();
                                String mensagem = "VOLTE SEMPRE: "+nome+"\n"+
                                        "Entrada: "+dataEntrada+"\n"+"Saída: "+horaAtual;
                                JOptionPane.showMessageDialog(null, new JTextArea(mensagem),
                            "SAÍDA", JOptionPane.PLAIN_MESSAGE);
                                Frame.limparFrame(frame.getFrameAutomatica());
                            }

                            catch(SQLException e){
                                throw new RuntimeException(e);
                            }
                        }
                        //Caso a pessoa esteja inativa no sistema
                        else{
                            JOptionPane.showMessageDialog(null, "PESSOA INATIVA!!!");
                            Frame.limparFrame(frame.getFrameAutomatica());
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
    }
}
