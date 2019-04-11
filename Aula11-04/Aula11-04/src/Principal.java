/**
 * Aula 11/04/2019
 * @author Gamarra
 */
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
       Imovel imovel = new Imovel();
       
       imovel.nomeProprietario = JOptionPane.showInputDialog(null, 
               "Digite o nome do proprietário: ", "CADASTRO",
               JOptionPane.PLAIN_MESSAGE);
       imovel.setCep(JOptionPane.showInputDialog(null, "Digite o CEP: ", "CADASTRO", JOptionPane.PLAIN_MESSAGE));
       
       JOptionPane.showMessageDialog(null, imovel.getCep());
    }
    
    //Recebe o nome do proprietario;
    //Recebe o cep do proprietario;
}
