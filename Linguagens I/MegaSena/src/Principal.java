/*
 * Classname             (Mega-Sena 1.0)
 * Version information   (1.0)
 * Date                  (15/03/2019 - 22:10)
 * author                (Cássio Gamarra)
 */

/**
 * Programa que gera até 10 cartões com os números da mega-sena aleatoriamente
 * Requisito: uma vez sorteada, uma dezena não pode estar presente em outro cartão
 */
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Principal {
    public static int[][] cartela = new int[6][10]; /* Matriz para receber os
                                                     * valores e gerar uma
                                                     * cartela
                                                     */
    public static int numeroCartelas;
    public static Random rand = new Random();
    
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, null, "MEGA-SENA 1.0", 
                JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/iconinicio.png"));
        while(!lerValor(numeroCartelas)){
            JOptionPane.showMessageDialog(null, "Digite um valor válido!", 
                    "ERRO!",JOptionPane.WARNING_MESSAGE);
        }
        gerador(numeroCartelas);
    }
    //Metódo para conferir se a nota digitada é válida
    public static boolean lerValor(int valor){
        //Verifica se um número foi digitado
        try{
            valor = Integer.parseInt(input("input",
                "Quantas cartelas deseja gerar?", "MEGA-SENA 1.0",
                JOptionPane.QUESTION_MESSAGE));
            
            //Caso o numero de cartelas seja 0 ou maior que 10
            if((valor < 1)||(valor >10)){ 
                return false;
            }
            else{
                numeroCartelas = valor;
                return true;
            }
        }
        
        //Caso uma letra seja digitada
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Saindo do sistema...",
                    "SAINDO" ,JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
            return false;
        }
    }
    //Método para gerar os números
    public static void gerador(int numeroCartelas){
        int aux, i, j, validador;
        
        JOptionPane.showMessageDialog(null, "Você escolheu "+numeroCartelas
                + " cartelas", "NUMERO CARTELAS", JOptionPane.INFORMATION_MESSAGE);
        
        JOptionPane.showMessageDialog(null,"SORTEANDO...", "SORTEANDO",
                JOptionPane.WARNING_MESSAGE);
        
        for(j = 0; j < numeroCartelas; j++){
            for(i = 0; i < 6;){
                aux = rand.nextInt(60) + 1;
                if(aux == 0){
                    //Se o valor for zero não armazena na cartela
                }
                else{
                    //Verificar se o número se repete
                    validador = testarValores(j, i, aux);
                    if(validador == 1){
                        cartela[i][j] = aux;
                        i++;
                    }
                }
            }
        }
        exibir(numeroCartelas);
        
    }
    //Método para testar se os valores não se repetem
    public static int testarValores(int j, int i, int aux){
        int iAnterior, jAnterior, resultado;
        resultado = 1;
        
        for(jAnterior = 0; jAnterior < j; jAnterior++){
            for(iAnterior = 0; iAnterior < 6; iAnterior++){
                if(aux == cartela[iAnterior][jAnterior]){
                    resultado = 0;
                }
            }
        }
        
        for(iAnterior = 0; iAnterior < i; iAnterior++){
            if(aux == cartela[iAnterior][j]){
                resultado = 0;
            }
        }
        return resultado;
    }
    
    //Método para ordenar a cartela
    public static void ordenar(int numeroCartelas){
        int i, j, k, aux;
        
        for(j = 0; j < numeroCartelas; j++){
            for(i = 0; i < 5; i++){
                for(k = i+1; k < 6; k++){
                    if(cartela[i][j] > cartela[k][j]){
                        aux = cartela[i][j];
                        cartela[i][j] = cartela[k][j];
                        cartela[k][j] = aux;
                    }
                }
            }
        }
    }
    
    //Método para exibir a cartela gerada
    public static void exibir(int numeroCartelas){
        int i, j;
        
        ordenar(numeroCartelas);
        
        String mensagem = "CARTELAS SORTEADAS:\n\n";
        
        for(j = 0; j < numeroCartelas; j++){
            mensagem = mensagem + (j+1)+"º cartela: "+"\n";
            
            for(i = 0; i < 5; i++){
                mensagem = mensagem + (cartela[i][j]) + " - ";
            }
            mensagem = mensagem + (cartela[5][j]) + "\n\n";
        }
        JOptionPane.showMessageDialog(null, mensagem, "Cartelas:", 1,
                new ImageIcon("src/icon.png"));
        
        JOptionPane.showMessageDialog(null, null, "MEGA-SENA 1.0", 
                JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/iconfinal.png"));
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