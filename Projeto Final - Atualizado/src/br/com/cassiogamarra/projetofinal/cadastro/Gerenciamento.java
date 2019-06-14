package br.com.cassiogamarra.projetofinal.cadastro;

import br.com.cassiogamarra.projetofinal.catracas.CatracaVirtual;
import br.com.cassiogamarra.projetofinal.classes.Pessoa;
import br.com.cassiogamarra.projetofinal.database.BancoDeDados;
import br.com.cassiogamarra.projetofinal.gui.FrameCatracas;
import br.com.cassiogamarra.projetofinal.gui.FramePessoas;
import br.com.cassiogamarra.projetofinal.utilitarios.Frame;
import br.com.cassiogamarra.projetofinal.utilitarios.Validador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
/**
 * Classe com os métodos para cadastro, consulta e exclusão
 * @author Gnomo
 */
public class Gerenciamento {
    
    public Gerenciamento(){}
    
    Validador validador = new Validador();
    BancoDeDados bd = new BancoDeDados();
    CatracaVirtual catraca = new CatracaVirtual();
    
    //Método para realizar o cadastro
    public  void cadastrar(Pessoa pessoa, String categoria, String textoCategoria){
        String sql = "INSERT INTO usuario(nome, cpf, telefone, dependentes, turma, cargo, observacoes, categoria, situacao)VALUES(?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = bd.conectar().prepareStatement(sql)){
               stmt.setString(1, pessoa.getNome());
               stmt.setString(2, pessoa.getCPF());
               stmt.setString(3, pessoa.getTelefone());
               stmt.setString(8, categoria);
               stmt.setInt(9, 1);
               if(categoria.equals("Responsável")){
                   stmt.setInt(4, Integer.parseInt(textoCategoria));
                   stmt.setString(5, "");
                   stmt.setString(6, "");
                   stmt.setString(7, "");
               }
               if(categoria.equals("Aluno")){
                   stmt.setString(5, textoCategoria);
                   stmt.setInt(4, 0);
                   stmt.setString(6, "");
                   stmt.setString(7, "");
               }
               if(categoria.equals("Colaborador")){
                   stmt.setString(6, textoCategoria);
                   stmt.setInt(4, 0);
                   stmt.setString(5, "");
                   stmt.setString(7, "");
               }
               if(categoria.equals("Visitante")){
                   stmt.setString(7, textoCategoria);
                   stmt.setInt(4, 0);
                   stmt.setString(5, "");
                   stmt.setString(6, "");
               }
               
               stmt.execute();
               JOptionPane.showMessageDialog(null, "CADASTRO CONCLUIDO COM SUCESSO!");
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    //Método para realizar uma consulta
    public void realizarConsulta(FramePessoas frame){
        if(!validador.validarCodigo(frame.getCampoConsulta().getText())){
            JOptionPane.showMessageDialog(null, "Consulta inválida!"
                    + "\nO código possui apenas 6 digitos numéricos");
            Frame.limparFrame(frame.getFrameConsultar());
        }
        else{
            long codigo = Long.parseLong(frame.getCampoConsulta().getText());
            try {
                if(bd.consultar(codigo).equals("")){
                    JOptionPane.showMessageDialog(null, "PESSOA NÃO ENCONTRADA");
                    Frame.limparFrame(frame.getFrameConsultar());
                }
                else{
                    frame.getTextoConsulta().setText(bd.consultar(codigo));
                    frame.getDialogConsulta().setVisible(true);
                    Frame.limparFrame(frame.getFrameConsultar());
                }
            } catch (SQLException ex) {
                Logger.getLogger(Gerenciamento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //Método para excluir um cadastro
    public void excluir(FramePessoas frame) throws SQLException{
        long codigo = Long.parseLong(frame.getCampoConsultaExclusao().getText());
        try{
            if(validador.verificarDependentes(codigo) != 0){
                JOptionPane.showMessageDialog(null, "RESPONSÁVEL NÃO PODE SER EXCLUIDO!");
            }
            else{
                String sql = "UPDATE usuario SET situacao = 0 WHERE codigo = "+codigo;
                int opcao;
                opcao = JOptionPane.showConfirmDialog(null, "DESEJA EXCLUIR?", "ALERTA!", JOptionPane.YES_NO_OPTION);
                if(opcao == JOptionPane.YES_OPTION){
                    try{
                        PreparedStatement stmt = bd.conectar().prepareStatement(sql);
                        stmt.execute();
                        JOptionPane.showMessageDialog(null, "PESSOA EXCLUIDA COM SUCESSO");
                        frame.getFrameExclusao().dispose();
                        Frame.limparFrame(frame.getFrameExcluir());
                    }
                    catch(SQLException e){
                       JOptionPane.showMessageDialog(null, "ERRO!");
                    }
                }
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(FramePessoas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Método para exibir os usuários ativos
    public void exibirAtivos() throws SQLException{
        String sql = "SELECT * FROM usuario WHERE situacao = 1";
        String mensagem = "";
        try{
            PreparedStatement stmt = bd.conectar().prepareStatement(sql);
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
            bd.conectar().close();
        }
        catch(SQLException e){
           throw new RuntimeException(e);
        }
    }
    //Método para exibir os usuários inativos
    public void exibirInativos() throws SQLException{
        String sql = "SELECT * FROM usuario WHERE situacao = 0";
        String mensagem = "";
        try{
            PreparedStatement stmt = bd.conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                String nome = consulta.getString("nome");
                String codigo = consulta.getString("codigo");
                if(mensagem.equals("")){
                    mensagem = "Código: "+codigo+" |  Nome: "+nome+"\n";
                }
                else{
                    mensagem = mensagem + "\nCódigo: "+codigo+" |  Nome: "+nome+"\n";
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
    //Método para exibir o histórico de entrada
    public void historicoEntrada() throws SQLException{
        String sql = "SELECT usuario.nome, catraca.codigo, catraca.dataHora FROM usuario, catraca WHERE usuario.codigo = catraca.codigo AND catraca.situacao = 1";
        String mensagem = "";
        
        try{
            PreparedStatement stmt = bd.conectar().prepareStatement(sql);
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
    //Método para exibir o histórico de saída
    public void historicoSaida() throws SQLException{
        String sql = "SELECT usuario.nome, catraca.codigo, catraca.dataHora FROM usuario, catraca WHERE usuario.codigo = catraca.codigo AND catraca.situacao = 0";
        String mensagem = "";
        
        try{
            PreparedStatement stmt = bd.conectar().prepareStatement(sql);
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
    //Método para gerenciar entrade e saída
    public void gerenciarEntradaSaida(FrameCatracas frame, int id){
        /*if(id == 1){
            if(!validador.validarCodigo(frame.getCampoConsulta().getText())){
                JOptionPane.showMessageDialog(null, "Código inválido!"
                        + "\nO código possui apenas 6 digitos numéricos");
                Frame.limparFrame(frame.getFrameEntrada());
            }
            else{
                long codigo = Long.parseLong(frame.getCampoConsulta().getText());
                catraca.entrada(codigo);
            }
        }
        if(id == 2){
            if(!validador.validarCodigo(frame.getCampoConsultaSaida().getText())){
                JOptionPane.showMessageDialog(null, "Código inválido!"
                        + "\nO código possui apenas 6 digitos numéricos");
                Frame.limparFrame(frame.getFrameSaida());
            }
            else{
                long codigo = Long.parseLong(frame.getCampoConsultaSaida().getText());
                catraca.saida(codigo);
            }
        }
        if(id == 3){
            if(!validador.validarCodigo(frame.getCampoConsultaAuto().getText())){
                JOptionPane.showMessageDialog(null, "Código inválido!"
                        + "\nO código possui apenas 6 digitos numéricos");
                Frame.limparFrame(frame.getFrameAutomatica());
            }
            else{
                long codigo = Long.parseLong(frame.getCampoConsultaAuto().getText());
            }
        }*/
    }
}