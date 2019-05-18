package br.com.cassiogamarra.projetofinal.utilitarios;


public class ValidarTelefone {
    public ValidarTelefone(){
        
    }
    
    public boolean validarTelefone(String telefone){
        
        if(telefone.matches("(10)|([1-9][1-9])[9][2-9][0-9]{3}[0-9]{4}")||
                telefone.matches("(10)|([1-9][1-9])[2-9][0-9]{3}[0-9]{4}")){
            return true;
        }
        return false;
    }
}
