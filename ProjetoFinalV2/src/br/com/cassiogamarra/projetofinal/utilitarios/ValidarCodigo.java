package br.com.cassiogamarra.projetofinal.utilitarios;

/**
 * Classe para validar o código para consulta e exclusão
 * @author Gamarra
 */
public class ValidarCodigo {
    
    public ValidarCodigo(){
    }
    
    public static boolean validarCodigo(String codigo){
        
        if((codigo.length()==5)&&(codigo.matches("[0-9]+"))){
            return true;
        }
        return false;
    }
}
