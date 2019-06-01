package br.com.cassiogamarra.projetofinal.cadastro;

import br.com.cassiogamarra.projetofinal.classes.Pessoa;
import br.com.cassiogamarra.projetofinal.database.*;
import br.com.cassiogamarra.projetofinal.gui.FramePessoas;
import br.com.cassiogamarra.projetofinal.utilitarios.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe para realizar o cadastro, com validação e cadastro.
 * @author Gnomo
 */

public class Cadastrar {
    
    public Cadastrar(){}
    
    ConectarDB conectar = new ConectarDB();
    ConsultarDuplicidade consultaD = new ConsultarDuplicidade();
    
    public void validarCadastro(FramePessoas frame) throws SQLException{
        Pessoa pessoa = new Pessoa();
        String especial = frame.getCampoCategoria().getText();
        String categoria = (String) frame.getComboBoxCategoria().getSelectedItem();
        
        pessoa.setNome(frame.getCampoNome().getText());
        pessoa.setCPF(frame.getCampoCPF().getText());
        pessoa.setTelefone(frame.getCampoTelefone().getText());
        
        if(!ValidarNome.validarNome(pessoa.getNome())){
            JOptionPane.showMessageDialog(null, "NOME INVÁLIDO");
        }
        else if(!ValidarCPF.isCPF(pessoa.getCPF())){
            JOptionPane.showMessageDialog(null, "CPF INVÁLIDO");
        }
        else if(!ValidarTelefone.validarTelefone(pessoa.getTelefone())){
            JOptionPane.showMessageDialog(null, "TELEFONE INVÁLIDO");
        }
        else if((frame.getCampoCategoria().getText().equals(""))||(categoria.equals(""))){
            JOptionPane.showMessageDialog(null, "POR FAVOR, PREENCHA A CATEGORIA");
        }
        else if(!consultaD.consultarDuplicidade(pessoa.getCPF())){
            JOptionPane.showMessageDialog(null, "O CADASTRO JÁ EXISTE");
        }
        else{
            try {
                cadastrar(pessoa, categoria, especial);
                LimparTela.LimparTela(frame.getFrameCadastrar());
            } catch (SQLException ex) {
                Logger.getLogger(FramePessoas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }   
    
    public void cadastrar(Pessoa pessoa, String categoria, String especial) throws SQLException{
        
       String sql = "INSERT INTO usuario(nome, cpf, telefone, dependentes,turma, cargo, observacoes, categoria, situacao)VALUES(?,?,?,?,?,?,?,?,?)";
       try (PreparedStatement stmt = conectar.conectar().prepareStatement(sql)){
               stmt.setString(1, pessoa.getNome());
               stmt.setString(2, pessoa.getCPF());
               stmt.setString(3, pessoa.getTelefone());
               stmt.setString(8, categoria);
               stmt.setInt(9, 1);
               if(categoria.equals("Responsável")){
                   stmt.setInt(4, Integer.parseInt(especial));
                   stmt.setString(5, "");
                   stmt.setString(6, "");
                   stmt.setString(7, "");
               }
               if(categoria.equals("Aluno")){
                   stmt.setString(5, especial);
                   stmt.setInt(4, 0);
                   stmt.setString(6, "");
                   stmt.setString(7, "");
               }
               if(categoria.equals("Colaborador")){
                   stmt.setString(6, especial);
                   stmt.setInt(4, 0);
                   stmt.setString(5, "");
                   stmt.setString(7, "");
               }
               if(categoria.equals("Visitante")){
                   stmt.setString(7, especial);
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
}
