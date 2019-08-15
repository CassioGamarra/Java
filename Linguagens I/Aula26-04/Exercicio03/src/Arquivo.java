import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class: Arquivo
 * @author Gamarra
 */
public class Arquivo extends Database{
    
    public void cadastrar(Uva uva){
        nomeBase = uva.getNome()+".txt";
        
        try (FileWriter arquivo = new FileWriter(nomeBase)){
            
            PrintWriter gravar = new PrintWriter(arquivo);
            
            gravar.printf("--->UVAS<---\n");
            gravar.printf("Nome: "+uva.getNome());
            gravar.printf("\nQuantidade: "+uva.getQuantidade());
            //arquivo.close();
        }
        catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
        System.out.println("Gravado com sucesso!");
    }
    
    public void cadastrar(Maca maca){
    }
}
