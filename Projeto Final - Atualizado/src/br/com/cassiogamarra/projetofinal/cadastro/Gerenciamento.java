package br.com.cassiogamarra.projetofinal.cadastro;

import br.com.cassiogamarra.projetofinal.classes.Pessoa;
import br.com.cassiogamarra.projetofinal.database.Database;
import br.com.cassiogamarra.projetofinal.gui.FramePessoas;
import br.com.cassiogamarra.projetofinal.utilitarios.Frame;
import br.com.cassiogamarra.projetofinal.utilitarios.Verificadores;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 * Classe com os métodos para cadastro, consulta e exclusão
 * @author Gnomo
 */
public class Gerenciamento {
    
    public Gerenciamento(){}
    
    Verificadores verificador = new Verificadores();
    Database database = new Database();
    //Método para realizar o cadastro
    public void cadastrar(Pessoa pessoa, String categoria, String textoCategoria){
        String sql = "INSERT INTO usuario(nome, cpf, telefone, dependentes, turma, cargo, observacoes, categoria, situacao)VALUES(?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = database.conectar().prepareStatement(sql)){
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
    //Método para validar uma consulta
    public void validarConsulta(FramePessoas frame){
        if(verificador.validarCodigo(frame.getCampoConsulta().getText())){
            JOptionPane.showMessageDialog(null, "Consulta inválida!"
                    + "\nO código possui apenas 6 digitos numéricos");
            Frame.limparFrame(frame.getFrameConsultar());
        }
        else{
            long codigo = Long.parseLong(frame.getCampoConsulta().getText());
            try {
                if(database.consultar(codigo).equals("")){
                    JOptionPane.showMessageDialog(null, "PESSOA NÃO ENCONTRADA");
                    Frame.limparFrame(frame.getFrameConsultar());
                }
                else{
                    frame.getTextoConsulta().setText(database.consultar(codigo));
                    frame.getDialogConsulta().setVisible(true);
                    Frame.limparFrame(frame.getFrameConsultar());
                }
            } catch (SQLException ex) {
                Logger.getLogger(Gerenciamento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //Método para realizar uma consulta
    //Método para excluir um cadastro
    //Método para exibir os usuários ativos
    //Método para exibir os usuários inativos
}
