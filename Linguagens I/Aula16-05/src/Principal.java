
import javax.swing.JOptionPane;

public class Principal {
    
    public static void main(String[] args) {
       Pessoa pessoa = new Pessoa();
       Cadastrar cadastro = new Cadastrar();
       Consultar consulta = new Consultar();
       
       int escolha;
       escolha = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - CADASTRAR / 2 - CONSULTAR"));
       
       if(escolha == 1){
            pessoa.setNome(JOptionPane.showInputDialog(null, "NOME: "));
            pessoa.setCPF(JOptionPane.showInputDialog(null, "CPF: "));
            pessoa.setEmail(JOptionPane.showInputDialog(null, "E-MAIL: "));
            pessoa.setTelefone(JOptionPane.showInputDialog(null, "TELEFONE: "));
            cadastro.cadastrar(pessoa);
       }
       if(escolha == 2){
            String msg = consulta.consultar(Long.parseLong(JOptionPane.showInputDialog(null, "Codigo: ")));
            JOptionPane.showMessageDialog(null, msg);
       }
       
       
       
    }
}
