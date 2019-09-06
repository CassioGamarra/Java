package gerenciadordecatracas.gerenciamento;

import gerenciadordecatracas.gui.MenuPessoas;
import gerenciadordecatracas.usuario.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Classe para validações relacionadas ao cadastro.
 * @author CassioGamarra
 */
public class CadastroValidator {
    
    public CadastroValidator(){}
    
    Conexao conexao = new Conexao();
    Utilitario utilitario = new Utilitario();
    Verificador verificador = new Verificador();
   
    //Método para validar um cadastro
    public void validarCadastro(MenuPessoas frame){
        Pessoa pessoa = new Pessoa();
        String tipoPessoa = (String)frame.getComboBoxCategoria().getSelectedItem();
        String conteudoTipoPessoa = frame.getCampoCategoria().getText();
        String CPF = frame.getCampoCPF().getText();
        String telefone = frame.getCampoTelefone().getText();
        
        CPF = CPF.replaceAll("\\D", "");
        telefone = telefone.replaceAll("\\D", "");
        
        pessoa.setNome(frame.getCampoNome().getText());
        pessoa.setCPF(CPF);
        pessoa.setTelefone(telefone);
        
        if(!verificador.isNome(pessoa.getNome())){
            JOptionPane.showMessageDialog(null, "NOME INVÁLIDO", "ERRO", 
                    JOptionPane.WARNING_MESSAGE);
        }
        else if(!verificador.isCPF(pessoa.getCPF())){
            JOptionPane.showMessageDialog(null, "CPF INVÁLIDO", "ERRO", 
                    JOptionPane.WARNING_MESSAGE);
        }
        else if(!consultarDuplicidade(pessoa.getCPF())){
            JOptionPane.showMessageDialog(null, "O CADASTRO JÁ EXISTE", "ERRO", 
                    JOptionPane.WARNING_MESSAGE);
        }
        else if(!verificador.isTelefone(pessoa.getTelefone())){
            JOptionPane.showMessageDialog(null, "TELEFONE INVÁLIDO", "ERRO",
                    JOptionPane.WARNING_MESSAGE);
        }
        else if((frame.getCampoCategoria().getText().equals(""))||(tipoPessoa.equals(""))){
            JOptionPane.showMessageDialog(null, "POR FAVOR, PREENCHA A CATEGORIA", 
                    "ERRO", JOptionPane.WARNING_MESSAGE);
        }
        else{
            Cadastro cadastro = new Cadastro();
            cadastro.cadastrar(pessoa, tipoPessoa, conteudoTipoPessoa);
            utilitario.limparFrame(frame.getFrameCadastrar());
        }
    }
    //Método para validar uma consulta
    public void validarConsulta(MenuPessoas frame){
        if(!verificador.isCodigo(frame.getCampoConsulta().getText())){
            JOptionPane.showMessageDialog(null, "Consulta inválida!"
                    + "\nO código possui apenas 6 digitos numéricos");
            utilitario.limparFrame(frame.getFrameConsultar());
        }
        else{
            Cadastro cadastro = new Cadastro();
            long codigo = Long.parseLong(frame.getCampoConsulta().getText());
            if(cadastro.consultar(codigo).equals("")){
                JOptionPane.showMessageDialog(null, "PESSOA NÃO ENCONTRADA");
                utilitario.limparFrame(frame.getFrameConsultar());
            }
            else{
                frame.getTextoConsulta().setText(cadastro.consultar(codigo));
                frame.getDialogConsulta().setVisible(true);
                utilitario.limparFrame(frame.getFrameConsultar());
            }
        }
    }
    //Método para consultar uma pessoa antes de excluir
    public void consultarExclusao(MenuPessoas frame){
        if(!verificador.isCodigo(frame.getCampoConsultaExclusao().getText())){
            JOptionPane.showMessageDialog(null, "Consulta inválida!"
                    + "\nO código possui apenas 6 digitos numéricos");
            utilitario.limparFrame(frame.getFrameExcluir());
        }
        else{
            Cadastro cadastro = new Cadastro();
            long codigo = Long.parseLong(frame.getCampoConsultaExclusao().getText());
            if(cadastro.consultar(codigo).equals("")){
                JOptionPane.showMessageDialog(null, "PESSOA NÃO ENCONTRADA");
                utilitario.limparFrame(frame.getFrameExcluir());
            }
            else{
                frame.getTextoExclusao().setText(cadastro.consultar(codigo));
                frame.getFrameExclusao().setVisible(true);
            }
        }
    }
    //Método para verificar se o responsável possui dependentes
    public int verificarDependentes(long codigo){
        String sql;
        int numDependentes = 0;
        //Procura um usuário ativo através do código
        sql = "SELECT * FROM usuario WHERE situacao = 1 AND codigo = "+codigo;
        try{
            PreparedStatement stmt = conexao.conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                String categoria = consulta.getString("categoria");
                if(categoria.equals("Responsável")){
                        String dependentes = consulta.getString("dependentes");
                        numDependentes = Integer.parseInt(dependentes);
                }
            }
        }
        catch(SQLException e){
           utilitario.erroTabela();
        }
        return numDependentes;
    }
    //Método que verifica se o cadastro já existe, baseado no CPF
    public boolean consultarDuplicidade(String CPF){
        String sql = "SELECT cpf FROM usuario WHERE cpf = "+CPF;
        String cpfConsulta = "";
        try{
            PreparedStatement stmt = conexao.conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                cpfConsulta = consulta.getString("cpf");
            }
            return !cpfConsulta.equals(CPF);
        }
        catch(SQLException e){
           utilitario.erroTabela();
           throw new RuntimeException(e);
        }
    }
}
