/**
 * Aula 11/04/2019
 * @author Gamarra
 */

import javax.swing.JOptionPane;

public class Imovel {
    public String nomeProprietario;
    private String cep;
    
    public void setCep(String cep){
        if(!cep.equals("00000000")&&(cep.length() == 8)){
            this.cep = cep;
        }
        else{
            JOptionPane.showMessageDialog(null,"CEP INVÁLIDO", "ALERTA",
                    JOptionPane.WARNING_MESSAGE);
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
