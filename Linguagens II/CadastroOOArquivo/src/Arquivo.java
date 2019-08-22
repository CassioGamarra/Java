
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Arquivo implements Persistencia {

    @Override
    public int cadastrar(Pessoa pessoa) {
        int dadosGravados=0;    
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(pessoa.getNome()+".txt"));
            bw.write(pessoa.getNome() + ";" + pessoa.getEmail() + ";" + pessoa.getEstadoCivil() + ";" + pessoa.getGenero() + ";" +
                    pessoa.getMaior18anos() + ";" + pessoa.getEscolaridade() + ";" + pessoa.getOutrasInformacoes());
            bw.close();
            dadosGravados = 1;
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            dadosGravados = 0;
        }
        
        return dadosGravados;
    }

    @Override
    public String[] consultar(String nome) {
        String[] vetor = null;
        String linha;
        String conteudo = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(nome+".txt"));
            while ((linha = br.readLine() ) != null) {
                 //System.out.println("Linha: " + linha);
                 conteudo = conteudo + linha;
             }
            br.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }    
        vetor = conteudo.split(";");
        return vetor;
    }
    
}
