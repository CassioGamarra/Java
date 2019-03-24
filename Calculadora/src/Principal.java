/*
 * Classname             (Calculadora)
 * Version information   (1.0)
 * Date                  ()
 * author                (Cássio Gamarra)
 */

/**
 * Implementar uma calculadora com as seguintes funcionalidades: 
 * 1 -  Menu com a possibilidade de ler dois valores; 
 * 2 - selecionar uma operação aritmética desejada; 
 * 3 - realizar o cálculo e exibir resultado.
 */
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, null, "CALCULADORA", 
                JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/icon.png"));
        calculadora();
    }
    
    //Método principal da calculadora
    public static void calculadora(){
        float a = 0;
        float b = 0;
        int op;
        validarNumero(a,b);
    }
    
    //Método para validar e ler os valores
    public static void validarNumero(float a, float b){
        boolean erro;
        do{
            try{
                a = Float.parseFloat(input("input", "Digite o valor de A: ",
                        "CALCULADORA", JOptionPane.PLAIN_MESSAGE));
                erro = true;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Informe apenas números", 
                        "ERRO!", JOptionPane.WARNING_MESSAGE);
                erro = false;
            }
        }while(!erro);
        
        do{
            try{
                b = Float.parseFloat(input("input", "Digite o valor de B: ",
                        "CALCULADORA", JOptionPane.PLAIN_MESSAGE));
                erro = true;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Informe apenas números", 
                        "ERRO!", JOptionPane.WARNING_MESSAGE);
                erro = false;
            }
        }while(!erro);
        
        escolherOperacao(a, b);
    }
    
    //Método para escolher operação
    public static void escolherOperacao(float a, float b){
        int op = 0;
        boolean erro;
        do{
            try{
                op = Integer.parseInt(input("input", "Qual operação deseja "
                        + "realizar?\n\n 1 - SOMA | 2 - SUBTRAÇÃO | "
                        + "3 - MULTIPLICAÇÃO | 4 - DIVISÃO\n"
                        + "OU QUALQUER OUTRO NÚMERO P/SAIR",
                        "CALCULADORA", JOptionPane.PLAIN_MESSAGE));
                erro = true;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Informe apenas números");
                erro = false;
            }
        }while(!erro);
        
        switch(op){
            case 1:
                JOptionPane.showMessageDialog(null, "SOMA = "+somar(a,b), "RESULTADO SOMA", JOptionPane.PLAIN_MESSAGE);
                mensagem();
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "SUBTRAÇÃO = "+subtrair(a,b), "RESULTADO SUBTRAÇÃO", JOptionPane.PLAIN_MESSAGE);
                mensagem();
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "MULTIPLICAÇÃO = "+multiplica(a,b), "RESULTADO MULTIPLICAÇÃO", JOptionPane.PLAIN_MESSAGE);
                mensagem();
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "DIVISÃO = "+divisao(a,b), "RESULTADO DIVISÃO", JOptionPane.PLAIN_MESSAGE);
                mensagem();
                break;
            default:
                mensagem();
                System.exit(0);
                break;
        }
    }
    
    //Operações//
    
    //Método de adição
    public static float somar(float a, float b){
        float soma = a + b;
        return soma;
    }
    
    //Método de subtração
    public static float subtrair(float a, float b){
        float sub = a - b;
        return sub;
    }
    
    //Método de multiplicação
    public static float multiplica(float a, float b){
        float mult = a * b;
        return mult;
    }
    
    //Método de divisão
    public static float divisao(float a, float b){
        float div = a/b;
        return div;
    }
    
    //Método genérico para abrir caixas de diálogo
    public static String input(String tipoMsg, String msg, String titulo, int
            tipo){
        String frase = null;
        
        if(tipoMsg.equals("input")){
            frase = JOptionPane.showInputDialog (null, msg, titulo, tipo);
        }
        if(tipoMsg.equals("msg")){
            //frase = ;
        }
        return frase;
    }
    public static void mensagem(){
        JOptionPane.showMessageDialog(null, null, "CALCULADORA", 
                JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/iconFinal.png"));
    }
}
