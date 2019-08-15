package br.com.cassiogamarra.projetofinal.utilitarios;

public class ValidarNome {
    
    public  ValidarNome(){
    }
    public static boolean validarNome(String nome){
        String valor = nome.toUpperCase();
        if(nome.length() < 3){
            return false;
        }
        else{
            String regex = "^[[ ]|\\p{L}*]+$";
            return valor.matches(regex);
        }
    }
}
