/**
 * Calculadora Binária
 * @author Gamarra
 */

import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        int entrada, valorA, valorB;
        String operacao, conversor, saida = "";
                 
        valorA = Integer.parseInt(JOptionPane.showInputDialog(null,
                "DIGITE O VALOR DE A: ", "CALCULADORA BINÁRIA",
                JOptionPane.QUESTION_MESSAGE));
        
        valorB = Integer.parseInt(JOptionPane.showInputDialog(null,
                "DIGITE O VALOR DE B: ", "CALCULADORA BINÁRIA",
                JOptionPane.QUESTION_MESSAGE));
        
        operacao = JOptionPane.showInputDialog(null,
                "QUAL OPERAÇÃO DESEJA REALIZAR? SOM - SUB", "CALCULADORA BINÁRIA",
                JOptionPane.QUESTION_MESSAGE).toUpperCase();
        
        if(operacao.equals("SOM")){
            entrada = valorA+valorB;
        }
        else if(operacao.equals("SUB")){
            entrada = valorA-valorB;
        }
        else{
            entrada = 0;
        }
        
        if((entrada > 127)||(entrada < -127)){
            JOptionPane.showMessageDialog(null, "VALOR FORA DO PERMITIDO!",
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
        else{
            
            conversor = converterBinario(entrada);
            
            if(conversor.length() < 7){
                int aux = 7 - conversor.length();
                for(;aux > 0; aux--){
                    conversor = '0'+conversor;
                }
            }
            if(entrada > 0){
                saida = "1"+conversor;
            }
            if(entrada < 0){
                saida = "0"+conversor;
            }
            
            JOptionPane.showMessageDialog(null, "SAÍDA: "+saida,
                    "CALCULADORA BINÁRIA", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static String converterBinario(int numInt){
        String binario = "";
        String binarioInv = "";
        int i;
        
        if(numInt < 0){
            numInt = numInt * (-1);
        }
        
        for(;numInt != 0; numInt = numInt/2){
            binario += "" + numInt%2;
        }
        
        for(i = (binario.length()); i != 0; i--){
            binarioInv += "" + binario.charAt(i-1);
        }
        
        return binarioInv;
    }
}