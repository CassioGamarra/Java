
import javax.swing.JOptionPane;

public class FilmesVHS extends Cadastro {
    
    @Override
    public void cadastrar(){
        this.setNome(JOptionPane.showInputDialog(null, "Nome"));
        this.setAno(Integer.parseInt(JOptionPane.showInputDialog(null, "Ano")));
        this.setPreco(Float.parseFloat(JOptionPane.showInputDialog(null, "Preço")));
        this.setRebobinado(JOptionPane.showInputDialog(null, "Rebobinado?"));
    }
    
    @Override
    public void exibir(){
        System.out.println("Nome: "+this.getNome());
        System.out.println("Ano: "+this.getAno());
        System.out.println("Preço: "+this.getPreco());
        System.out.println("Rebobinado: "+this.getRebobinado());
    }
}
