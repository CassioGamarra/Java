package br.com.cassiogamarra.projetofinal.cadastro;
import br.com.cassiogamarra.projetofinal.classes.Pessoa;
import br.com.cassiogamarra.projetofinal.database.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Cadastrar {
    
    public Cadastrar(){
    
    }
    public static void cadastrar(Pessoa pessoa, String categoria, String especial) throws SQLException{
        
       Connection conectar = ConectarDB.conectar();
       
       String sql = "INSERT INTO usuarios(nome, cpf, telefone, dependentes,turma, cargo, observacoes)VALUES(?,?,?,?,?,?,?)";
       try (PreparedStatement stmt = conectar.prepareStatement(sql)) {
               stmt.setString(1, pessoa.getNome());
               stmt.setString(2, pessoa.getCPF());
               stmt.setString(3, pessoa.getTelefone());
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
