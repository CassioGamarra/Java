package classes;
import database.ConectarBD;
import gui.FramePessoas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Cadastrar {
    
    public Cadastrar(){
    }
    public static boolean cadastrar(String nome, String cpf, String telefone, String especial, String comboBox){
        Connection conectar = new ConectarBD().conectar("jdbc:mysql://localhost:3306/teste","root","");
        FramePessoas frame = new FramePessoas();
        
        
        String sql = "INSERT INTO usuarios(nome, cpf, telefone, dependentes,turma, cargo, observacoes)VALUES(?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = conectar.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, telefone);
            if(comboBox.equals("Responsável")){
                stmt.setInt(4, Integer.parseInt(especial));
                stmt.setString(5, "");
                stmt.setString(6, "");
                stmt.setString(7, ""); 
            }
            if(comboBox.equals("Aluno")){
                stmt.setString(5, especial);
                stmt.setInt(4, 0);
                stmt.setString(6, "");
                stmt.setString(7, "");
            }
            if(comboBox.equals("Colaborador")){
                stmt.setString(6, especial);
                stmt.setInt(4, 0);
                stmt.setString(5, "");
                stmt.setString(7, "");
            }
            if(comboBox.equals("Visitante")){
                stmt.setString(7, especial);
                stmt.setInt(4, 0);
                stmt.setString(5, "");
                stmt.setString(6, "");
            }
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "CADASTRO CONCLUIDO COM SUCESSO!");
            
            stmt.close();
            return true;
        }
        
        catch(SQLException e){
            
            throw new RuntimeException(e);
            
        }
    }
}
