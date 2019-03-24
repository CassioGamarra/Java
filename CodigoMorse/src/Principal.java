/*
 * Classname             (Código MORSE)
 * 
 * Version information   (1.0)
 *
 * Date                  (17/03/2019 - 17:40)
 * 
 * author                (Cássio Gamarra)
 * 
 */

//Imagem de referência -> https://seagirl.pt/wp-content/uploads/2017/11/Letras_Morse0001.jpg
import javax.swing.JOptionPane;

public class Principal{
    public static void main(String[] args) {
        
        //Dois tipos de conversão: para texto puro ou binário
        int tipo = Integer.parseInt(input("input",
                "1 - CONVERTER PARA TEXTO | 2 - CONVERTER PARA BINÁRIO",
                "MORSE 1.0", JOptionPane.QUESTION_MESSAGE));
        
        entradaFrase(tipo);
    }
    public static void entradaFrase(int tipo){
        String frase = "";
        int i, tamanhoPalavra;
        
        int numPalavras = Integer.parseInt(input("input", 
                "Quantas palavras contem sua frase?", "MORSE 1.0", 
                JOptionPane.QUESTION_MESSAGE));
        
        for(i = 0; i < numPalavras; i++){
            tamanhoPalavra = Integer.parseInt(input("input",
                    "Quantas letras contem sua "+(i+1)+"ª palavra?",
                    "MORSE 1.0", JOptionPane.QUESTION_MESSAGE));
            frase = frase +"  "+entradaPalavra(tamanhoPalavra, tipo);
        }
        System.out.println("Saida = "+frase);
        JOptionPane.showMessageDialog(null,"TRADUÇÃO: "+frase);
    }
    
    public static String entradaPalavra(int numLetras, int tipo){
        char[] palavra = new char[4];
        String saidaTexto = "";
        String saidaBinario = "";
        int i, j, cont;
        
        for(i = 0; i < numLetras;i++){
            cont = 0;
            palavra = input("input", "Digite a "+ (i+1) +"ª letra: ", "MORSE 1.0",
                    JOptionPane.PLAIN_MESSAGE).toCharArray();
            
            for(j = 0; j < palavra.length; j++){
                cont++;
            }
            saidaTexto = saidaTexto + alfabeto(cont, palavra); //Entra no método para converter em texto
            saidaBinario = saidaBinario + binario(cont, palavra); //Entra no método para converter em binário
            System.out.print("Entrada "+(i+1)+" = ");
            System.out.print(palavra);
            System.out.println("");
        }
        
        if(tipo == 1) return saidaTexto;
        
        else if(tipo == 2) return saidaBinario;
        
        else return "";
    }
    
    //DICIONÁRIO PARA CONVERSÃO EM LETRAS
    public static String alfabeto(int cont, char[]mensagem){
        String saida = "";
        
        if(cont == 1){
            if(mensagem[0] == '.')saida = "E"; //E
            if(mensagem[0] == '-')saida = "T"; //T
        }
        if(cont == 2){
            if((mensagem[0] == '-')&&(mensagem[1] == '-')) saida = "M"; //M
            if((mensagem[0] == '-')&&(mensagem[1] == '.')) saida = "N"; //N
            if((mensagem[0] == '.')&&(mensagem[1] == '-')) saida = "A"; //A
            if((mensagem[0] == '.')&&(mensagem[1] == '.')) saida = "I"; //I
        }
        if(cont == 3){
            if((mensagem[0] == '-')&&(mensagem[1] == '-')&&(mensagem[2] == '-')) saida = "O"; //O
            if((mensagem[0] == '-')&&(mensagem[1] == '-')&&(mensagem[2] == '.')) saida = "G"; //G
            if((mensagem[0] == '-')&&(mensagem[1] == '.')&&(mensagem[2] == '-')) saida = "K"; //K
            if((mensagem[0] == '-')&&(mensagem[1] == '.')&&(mensagem[2] == '.')) saida = "D"; //D
            if((mensagem[0] == '.')&&(mensagem[1] == '-')&&(mensagem[2] == '-')) saida = "W"; //W
            if((mensagem[0] == '.')&&(mensagem[1] == '-')&&(mensagem[2] == '.')) saida = "R"; //R
            if((mensagem[0] == '.')&&(mensagem[1] == '.')&&(mensagem[2] == '-')) saida = "U"; //U
            if((mensagem[0] == '.')&&(mensagem[1] == '.')&&(mensagem[2] == '.')) saida = "S"; //S
        }
        if(cont == 4){
            if((mensagem[0] == '-')&&(mensagem[1] == '-')&&(mensagem[2] == '.')&&(mensagem[3] == '-')) saida = "Q"; //Q
            if((mensagem[0] == '-')&&(mensagem[1] == '-')&&(mensagem[2] == '.')&&(mensagem[3] == '.')) saida = "Z"; //Z
            if((mensagem[0] == '-')&&(mensagem[1] == '.')&&(mensagem[2] == '.')&&(mensagem[3] == '-')) saida = "X"; //X
            if((mensagem[0] == '-')&&(mensagem[1] == '.')&&(mensagem[2] == '.')&&(mensagem[3] == '.')) saida = "B"; //B
            if((mensagem[0] == '.')&&(mensagem[1] == '-')&&(mensagem[2] == '.')&&(mensagem[3] == '.')) saida = "L"; //L
            if((mensagem[0] == '.')&&(mensagem[1] == '.')&&(mensagem[2] == '.')&&(mensagem[3] == '-')) saida = "V"; //V
            if((mensagem[0] == '.')&&(mensagem[1] == '.')&&(mensagem[2] == '.')&&(mensagem[3] == '.')) saida = "H"; //H
            if((mensagem[0] == '-')&&(mensagem[1] == '.')&&(mensagem[2] == '-')&&(mensagem[3] == '-')) saida = "Y"; //Y
            if((mensagem[0] == '-')&&(mensagem[1] == '.')&&(mensagem[2] == '-')&&(mensagem[3] == '.')) saida = "C"; //C
            if((mensagem[0] == '.')&&(mensagem[1] == '-')&&(mensagem[2] == '-')&&(mensagem[3] == '-')) saida = "J"; //J
            if((mensagem[0] == '.')&&(mensagem[1] == '-')&&(mensagem[2] == '-')&&(mensagem[3] == '.')) saida = "P"; //P
            if((mensagem[0] == '.')&&(mensagem[1] == '.')&&(mensagem[2] == '-')&&(mensagem[3] == '.')) saida = "F"; //F
        }
        return saida;
    }
    
    //DICIONÁRIO PARA CONVERSÃO EM BINÁRIO
    public static String binario(int cont, char[]mensagem){
        String saida = "";
        
        if(cont == 1){
            if(mensagem[0] == '.')saida = "00100"; //E
            if(mensagem[0] == '-')saida = "10011"; //T
        }
        if(cont == 2){
            if((mensagem[0] == '-')&&(mensagem[1] == '-')) saida = "01100"; //M
            if((mensagem[0] == '-')&&(mensagem[1] == '.')) saida = "01101"; //N
            if((mensagem[0] == '.')&&(mensagem[1] == '-')) saida = "00000"; //A
            if((mensagem[0] == '.')&&(mensagem[1] == '.')) saida = "01000"; //I
        }
        if(cont == 3){
            if((mensagem[0] == '-')&&(mensagem[1] == '-')&&(mensagem[2] == '-')) saida = "01110"; //O
            if((mensagem[0] == '-')&&(mensagem[1] == '-')&&(mensagem[2] == '.')) saida = "00110"; //G
            if((mensagem[0] == '-')&&(mensagem[1] == '.')&&(mensagem[2] == '-')) saida = "01010"; //K
            if((mensagem[0] == '-')&&(mensagem[1] == '.')&&(mensagem[2] == '.')) saida = "00011"; //D
            if((mensagem[0] == '.')&&(mensagem[1] == '-')&&(mensagem[2] == '-')) saida = "10110"; //W
            if((mensagem[0] == '.')&&(mensagem[1] == '-')&&(mensagem[2] == '.')) saida = "10001"; //R
            if((mensagem[0] == '.')&&(mensagem[1] == '.')&&(mensagem[2] == '-')) saida = "10100"; //U
            if((mensagem[0] == '.')&&(mensagem[1] == '.')&&(mensagem[2] == '.')) saida = "10010"; //S
        }
        if(cont == 4){
            if((mensagem[0] == '-')&&(mensagem[1] == '-')&&(mensagem[2] == '.')&&(mensagem[3] == '-')) saida = "10000"; //Q
            if((mensagem[0] == '-')&&(mensagem[1] == '-')&&(mensagem[2] == '.')&&(mensagem[3] == '.')) saida = "11001"; //Z
            if((mensagem[0] == '-')&&(mensagem[1] == '.')&&(mensagem[2] == '.')&&(mensagem[3] == '-')) saida = "10111"; //X
            if((mensagem[0] == '-')&&(mensagem[1] == '.')&&(mensagem[2] == '.')&&(mensagem[3] == '.')) saida = "00001"; //B
            if((mensagem[0] == '.')&&(mensagem[1] == '-')&&(mensagem[2] == '.')&&(mensagem[3] == '.')) saida = "01011"; //L
            if((mensagem[0] == '.')&&(mensagem[1] == '.')&&(mensagem[2] == '.')&&(mensagem[3] == '-')) saida = "10101"; //V
            if((mensagem[0] == '.')&&(mensagem[1] == '.')&&(mensagem[2] == '.')&&(mensagem[3] == '.')) saida = "00111"; //H
            if((mensagem[0] == '-')&&(mensagem[1] == '.')&&(mensagem[2] == '-')&&(mensagem[3] == '-')) saida = "11000"; //Y
            if((mensagem[0] == '-')&&(mensagem[1] == '.')&&(mensagem[2] == '-')&&(mensagem[3] == '.')) saida = "00010"; //C
            if((mensagem[0] == '.')&&(mensagem[1] == '-')&&(mensagem[2] == '-')&&(mensagem[3] == '-')) saida = "01001"; //J
            if((mensagem[0] == '.')&&(mensagem[1] == '-')&&(mensagem[2] == '-')&&(mensagem[3] == '.')) saida = "01111"; //P
            if((mensagem[0] == '.')&&(mensagem[1] == '.')&&(mensagem[2] == '-')&&(mensagem[3] == '.')) saida = "00101"; //F
        }
        return saida;
    }
    
    //Método genérico para abrir caixas de diálogo
    public static String input(String tipoMsg, String msg, String titulo, int
            tipo){
        String frase = null;
        
        if(tipoMsg.equals("input")){
            frase = JOptionPane.showInputDialog (null, msg, titulo, tipo);
        }
        if(tipoMsg.equals("opcao")){
            frase = Integer.toString(JOptionPane.showConfirmDialog(null, msg,
                    titulo, tipo));
        }
        return frase;
    }
}