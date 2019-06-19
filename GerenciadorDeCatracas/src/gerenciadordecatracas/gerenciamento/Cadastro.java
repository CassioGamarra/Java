package gerenciadordecatracas.gerenciamento;

import gerenciadordecatracas.gui.MenuPessoas;
import gerenciadordecatracas.usuario.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Classe para operações relacionadas ao cadastro.
 * @author Gnomo
 */
public class Cadastro {
    Conexao conexao = new Conexao();
    Utilitario utilitario = new Utilitario();
    CadastroValidator validarExclusao = new CadastroValidator();
    
    //Método para cadastrar uma pessoa
    public void cadastrar(Pessoa pessoa, String tipoPessoa, String conteudoTipoPessoa){
        String sql = "INSERT INTO usuario(nome, cpf, telefone, dependentes, "
                + "turma, cargo, observacoes, categoria, "
                + "situacao)VALUES(?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = conexao.conectar().prepareStatement(sql)){
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getCPF());
            stmt.setString(3, pessoa.getTelefone());
            stmt.setString(8, tipoPessoa);
            stmt.setInt(9, 1);
            
            if(tipoPessoa.equals("Responsável")){
                stmt.setInt(4, Integer.parseInt(conteudoTipoPessoa));
                stmt.setString(5, "");
                stmt.setString(6, "");
                stmt.setString(7, "");
            }
            if(tipoPessoa.equals("Aluno")){
                stmt.setString(5, conteudoTipoPessoa);
                stmt.setInt(4, 0);
                stmt.setString(6, "");
                stmt.setString(7, "");
            }
            if(tipoPessoa.equals("Colaborador")){
                stmt.setString(6, conteudoTipoPessoa);
                stmt.setInt(4, 0);
                stmt.setString(5, "");
                stmt.setString(7, "");
            }
            if(tipoPessoa.equals("Visitante")){
                stmt.setString(7, conteudoTipoPessoa);
                stmt.setInt(4, 0);
                stmt.setString(5, "");
                stmt.setString(6, "");
            }
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "CADASTRO CONCLUIDO COM SUCESSO!", 
                    "SUCESSO!", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException e){
            utilitario.erroTabela();
        }
    }
    //Método para consultar uma pessoa
    public String consultar(long codigo){
        String mensagem = "";
        
        String sql = "SELECT * FROM usuario WHERE situacao = 1 AND codigo = "+codigo;
        
        try{
            PreparedStatement stmt = conexao.conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                String nome = consulta.getString("nome");
                String cpf = consulta.getString("cpf");
                String telefone = consulta.getString("telefone");
                String categoria = consulta.getString("categoria");
                String textoCategoria = "", nomeCategoria = "";
                if(categoria.equals("Responsável")){
                    textoCategoria = consulta.getString("dependentes");
                    nomeCategoria = "Dependentes: ";
                    int dependentes = Integer.parseInt(textoCategoria);
                }
                if(categoria.equals("Aluno")){
                    textoCategoria = consulta.getString("turma");
                    nomeCategoria = "Turma: ";
                }
                if(categoria.equals("Colaborador")){
                    textoCategoria = consulta.getString("cargo");
                    nomeCategoria = "Cargo: ";
                }
                if(categoria.equals("Visitante")){
                    textoCategoria = consulta.getString("observacoes");
                    nomeCategoria = "Observações: ";
                }
                mensagem = "Nome: "+nome+
                        "\nCPF: "+cpf+
                        "\nTelefone: "+telefone+
                        "\n"+nomeCategoria+textoCategoria;
            }
            return mensagem;
        }
        catch(SQLException e){
            utilitario.erroTabela();
            throw new RuntimeException(e);
        }
    }
    //Método para excluir uma pessoa
    public void excluir(MenuPessoas frame){
        long codigo = Long.parseLong(frame.getCampoConsultaExclusao().getText());
        if(validarExclusao.verificarDependentes(codigo) != 0){
            JOptionPane.showMessageDialog(null, "RESPONSÁVEL NÃO PODE SER EXCLUIDO!");
        }
        else{
            String sql = "UPDATE usuario SET situacao = 0 WHERE codigo = "+codigo;
            int opcao;
            opcao = JOptionPane.showConfirmDialog(null, "DESEJA EXCLUIR?", "ALERTA!", JOptionPane.YES_NO_OPTION);
            
            if(opcao == JOptionPane.YES_OPTION){
                try{
                    PreparedStatement stmt = conexao.conectar().prepareStatement(sql);
                    stmt.execute();
                    JOptionPane.showMessageDialog(null, "PESSOA EXCLUIDA COM SUCESSO");
                    frame.getFrameExclusao().dispose();
                    utilitario.limparFrame(frame.getFrameExcluir());
                }
                catch(SQLException e){
                    utilitario.erroTabela();
                }
            }
        }
    }
    //Método para resetar os excluidos
    public void resetarExcluidos(){
        String sql = "UPDATE usuario SET situacao = 1";
        int opcao;
        opcao = JOptionPane.showConfirmDialog(null, "DESEJA ATUALIZAR?",
                "ALERTA!", JOptionPane.YES_NO_OPTION);
        
        if(opcao == JOptionPane.YES_OPTION){
            try{
                PreparedStatement stmt;
                stmt = conexao.conectar().prepareStatement(sql);
                stmt.execute();
                JOptionPane.showMessageDialog(null,
                        "REGISTROS ATUALIZADOS COM SUCESSO!");
            }
            catch(SQLException e){
               utilitario.erroTabela();
            }
        }
        else{
            JOptionPane.showMessageDialog(null,
                    "REGISTROS NÃO FORAM MODIFICADOS!");
        }
    }
}
