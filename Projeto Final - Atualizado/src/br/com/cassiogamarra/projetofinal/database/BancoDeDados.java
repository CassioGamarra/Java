package br.com.cassiogamarra.projetofinal.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Classe com os métodos relacionados ao banco de dados
 * @author Gnomo
 */
public class BancoDeDados {
    public BancoDeDados(){}
    
    //Método para testar a conexão com o banco
    public static void main(String[] args) throws SQLException{
        BancoDeDados conectar = new BancoDeDados();
        conectar.conectar();
    }
    //Método para conectar com o banco de dados
    public Connection conectar() throws SQLException{
        Connection conectar = null;
        try{
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancocatracas","root","");
            return conectar;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possivel conectar");
        }
        return conectar;
    }
    //Método para realizar uma consulta no banco de dados
    public String consultar(long codigo) throws SQLException{
        String mensagem = "";
        String sql = "SELECT * FROM usuario WHERE situacao = 1 AND codigo = "+codigo;
        BancoDeDados conectar = new BancoDeDados();
        
        PreparedStatement stmt = conectar.conectar().prepareStatement(sql);
        ResultSet consulta = stmt.executeQuery(sql);
        while(consulta.next()){
            String nome = consulta.getString("nome");
            String cpf = consulta.getString("cpf");
            String telefone = consulta.getString("telefone");
            String categoria = consulta.getString("categoria");
            String textoCategoria = "", lblCategoria = "";   
            if(categoria.equals("Responsável")){
                textoCategoria = consulta.getString("dependentes");
                lblCategoria = "Dependentes: ";
                int dependentes = Integer.parseInt(textoCategoria);
            }
            if(categoria.equals("Aluno")){
                textoCategoria = consulta.getString("turma");
                lblCategoria = "Turma: ";
            }
            if(categoria.equals("Colaborador")){
                textoCategoria = consulta.getString("cargo");
                lblCategoria = "Cargo: ";
            }
            if(categoria.equals("Visitante")){
                textoCategoria = consulta.getString("observacoes");
                lblCategoria = "Observações: ";
            }
            mensagem = "Nome: "+nome+ "\nCPF: "+cpf+"\nTelefone: "+telefone+
                    "\n"+lblCategoria+textoCategoria;
        }
        return mensagem;
    }
    //Método para resetar os excluidos do banco
    public void resetarExcluidos() throws SQLException{
        BancoDeDados database = new BancoDeDados();
        
        String sql = "UPDATE usuario SET situacao = 1";
        int opcao;
        opcao = JOptionPane.showConfirmDialog(null, "DESEJA ATUALIZAR?",
                "ALERTA!", JOptionPane.YES_NO_OPTION);
        
        if(opcao == JOptionPane.YES_OPTION){
            try{
                PreparedStatement stmt;
                stmt = database.conectar().prepareStatement(sql);
                stmt.execute();
                JOptionPane.showMessageDialog(null, "REGISTROS ATUALIZADOS COM SUCESSO!");
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, "ERRO!");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "REGISTROS NÃO FORAM MODIFICADOS!");
        }
    }
}
