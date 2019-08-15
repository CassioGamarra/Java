
import java.net.URL;

/**
 * Aula 11/04/2019
 * @author Gamarra
 */

public class Imovel {
    public String nomeProprietario;
    private String cep;
    
    public void setCep(String cep){
        try{
            URL url = new URL("https://viacep.com.br/ws/"+ cep +"/json");
        }
        catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
    }
    
    public String getCep(){
        if(cep == null){
            return "Cep inválido";
        }
        return cep;
    }
    
    //Funções para definir o CEP(Void) -> set
    //Função para get CEP: string ->notEquals("0000000") e 8 digitos
    //No set faz a verificação do cep
    
    
    
}
