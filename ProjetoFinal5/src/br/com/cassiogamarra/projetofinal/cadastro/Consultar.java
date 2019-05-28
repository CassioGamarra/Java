package br.com.cassiogamarra.projetofinal.cadastro;

import br.com.cassiogamarra.projetofinal.database.*;
import br.com.cassiogamarra.projetofinal.gui.FramePessoas;
import br.com.cassiogamarra.projetofinal.utilitarios.LimparTela;
import br.com.cassiogamarra.projetofinal.utilitarios.ValidarCodigo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Consultar {
    
    public Consultar(){
    }
    
    public static void validarConsulta(FramePessoas frame){
        if(!ValidarCodigo.validarCodigo(frame.getCampoConsulta().getText())){
            JOptionPane.showMessageDialog(null, "Consulta inválida!"
                    + "\nO código possui apenas 6 digitos numéricos");
            LimparTela.LimparTela(frame.getFrameConsultar());
        }
        else{
            long codigo = Long.parseLong(frame.getCampoConsulta().getText());
            try{
                if(Consultar.consultar(codigo).equals("")){
                    JOptionPane.showMessageDialog(null, "PESSOA NÃO ENCONTRADA");
                    LimparTela.LimparTela(frame.getFrameConsultar());
                }
                else{
                    frame.getTextoConsulta().setText(Consultar.consultar(codigo));
                    frame.getDialogConsulta().setVisible(true);
                    LimparTela.LimparTela(frame.getFrameConsultar());
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(FramePessoas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static String consultar(long codigo) throws SQLException{
        String mensagem = "";
        
        Connection conectar = ConectarDB.conectar();
        String sql = "SELECT * FROM usuario WHERE situacao = 1 AND codigo = "+codigo;
        
        try{
            PreparedStatement stmt = conectar.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                String nome = consulta.getString("nome");
                String cpf = consulta.getString("cpf");
                String telefone = consulta.getString("telefone");
                String categoria = consulta.getString("categoria");
                String especial = "", nomeEspecial = "";
                if(categoria.equals("Responsável")){
                    especial = consulta.getString("dependentes");
                    nomeEspecial = "Dependentes: ";
                    int dependentes = Integer.parseInt(especial);
                }
                if(categoria.equals("Aluno")){
                    especial = consulta.getString("turma");
                    nomeEspecial = "Turma: ";
                }
                if(categoria.equals("Colaborador")){
                    especial = consulta.getString("cargo");
                    nomeEspecial = "Cargo: ";
                }
                if(categoria.equals("Visitante")){
                    especial = consulta.getString("observacoes");
                    nomeEspecial = "Observações: ";
                }
                mensagem = "Nome: "+nome+
                        "\nCPF: "+cpf+
                        "\nTelefone: "+telefone+
                        "\n"+nomeEspecial+especial;
            }
            return mensagem;
        }
        catch(SQLException e){
           throw new RuntimeException(e);
        }
    }
}
