/*
 * Classname             ()
 * Version information   ()
 * Date                  ()
 * author                (Cássio Gamarra)
 */

/**
 *
 * @author Gnomo
 */
public class Principal extends Calculadora {

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        
        calc.setVisible(true);
        calc.setLocationRelativeTo(null);
    }
    
    public static String calcular(){
        int numA, numB, resultInt = 0;
        String resultado;
        try{
            numA = converter(Calculadora.valorA);
            numB = converter(Calculadora.valorB);
            
            if(operacao() == 1) resultInt = numA + numB;
            if(operacao() == 2) resultInt = numA - numB;
            if(operacao() == 3) resultInt = numA * numB;
            if(operacao() == 4) resultInt = numA / numB;
            
            resultado = converterBinario(resultInt);
            
            if(resultado.length() > 4 || resultInt  < 0){
                resultado = "ALERTA";
            }
            if(resultado.length() < 4){
                int aux = 4 - resultado.length();
                for(;aux > 0; aux--){
                    resultado = '0'+resultado;
                }
            }
        
        }
        catch(Exception e){
            resultado = "ALERTA";
        }
        
        return resultado;
    }
    
    public static int operacao(){
        try{
            if(Calculadora.valorOp.equals("00")) return 1;
            if(Calculadora.valorOp.equals("01")) return 2;
            if(Calculadora.valorOp.equals("10")) return 3;
            if(Calculadora.valorOp.equals("11")) return 4;
        }
        catch(Exception e){
            if(e.getMessage().equals("null")){
                Calculadora.valorResultado = "ALERTA";
            }
        }
        return 1;
    }
    
    public static int converter(String numero){
        int numInt = 0, pos;
        
        for(pos = 0; pos < 4; pos++){
            if (numero.charAt(pos) == '1'){
                numInt = numInt+aumentar(pos);
            }
        }
        
        return numInt;
    }
    
    public static String converterBinario(int numInt){
        String binario = "";
        String binarioInv = "";
        int i;
        
        for(;numInt != 0; numInt = numInt/2){
            binario += "" + numInt%2;
        }
        
        for(i = (binario.length()); i != 0; i--){
            binarioInv += "" + binario.charAt(i-1);
        }
        
        return binarioInv;
    }
    
    public static int aumentar(int pos){
        int aumentar = 1, i = 3 - pos;
        
        for(;i > 0; i--){
            aumentar = aumentar * 2;
        }
        
        return aumentar;
    }
}
