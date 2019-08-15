import java.io.IOException;
import javax.swing.JOptionPane;

public class Principal {
    private Maca maca;
    private Uva uva;
    private Arquivo arquivo;
    
    public static void main(String[] args){
        Uva uva = new Uva();
        Arquivo arquivo = new Arquivo();
        
        uva.setNome(JOptionPane.showInputDialog(null, "Digite o nome da uva: "));
        
        uva.setQuantidade(Float.parseFloat(JOptionPane.showInputDialog(null,
                "Digite a quantidade: ")));

        arquivo.cadastrar(uva);
    }
}
