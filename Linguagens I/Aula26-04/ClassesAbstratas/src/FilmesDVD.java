
import javax.swing.JOptionPane;

public class FilmesDVD extends Cadastro{
    
    
    @Override
    public void cadastrar(){
        this.setNome(JOptionPane.showInputDialog(null, "Nome"));
        this.setAno(Integer.parseInt(JOptionPane.showInputDialog(null, "Ano")));
        this.setPreco(Float.parseFloat(JOptionPane.showInputDialog(null, "Preço")));
        this.setRegiao(Integer.parseInt(JOptionPane.showInputDialog(null, "Região")));
    }
    
    @Override
    public void exibir(){
        System.out.println("Nome: "+this.getNome());
        System.out.println("Ano: "+this.getAno());
        System.out.println("Preço: "+this.getPreco());
        System.out.println("Região: "+this.getRegiao());
    }
}
