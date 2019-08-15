
import javax.swing.JOptionPane;


public class Principal {

    public static void main(String[] args) {
        Cadastro vhs = new FilmesVHS();
        Cadastro dvd = new FilmesDVD();
        
        int opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                "CADASTRO: 1-DVD // 2 - VHS"));
        
        switch (opcao) {
            case 1:
                dvd.cadastrar();
                dvd.exibir();
                break;
            case 2:
                vhs.cadastrar();
                vhs.exibir();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida");
                break;
        }
    }
    
}
