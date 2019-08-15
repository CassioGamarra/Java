/*Desenvolver uma aplicação para ranking/classificação de atletas (nomes e notas)
 *  O programa deve:
 *      1 - solicitar nomes e notas
 *      2 - classificar os atletas (da maior nota para a menor)
 *      3 - exibir a classificação
 */

/*
 * Classname             (Cadastro de Atletas)
 * 
 * Version information   (1.0)
 *
 * Date                  (10/03/2019 - 17:40)
 * 
 * author                (Cássio Gamarra)
 * 
 */

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Principal {
    
    public static void main(String[] args) {
        cadastro(); 
    }
    
    //Metódo para realizar o cadastro
    public static void cadastro(){
        String[] atletas = new String[10];
        float[] notas = new float[10];
        String opcao;
        int i;
        
        JOptionPane.showMessageDialog(null, null, "CADASTRO", 
                JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/icon.png"));
        for(i = 0;i<10; i++){
            //Caso o valor retornado seja falso digita novamente o nome
            while(!lerNome(atletas, i)){
                JOptionPane.showConfirmDialog(null, "Digite um valor válido!"
                            , "ERRO!", JOptionPane.PLAIN_MESSAGE);
            }
            //Caso o valor retornado seja falso digita novamente a nota
            while(!lerNotas(notas, i)){
                JOptionPane.showConfirmDialog(null, "Digite um valor válido!"
                            , "ERRO!", JOptionPane.PLAIN_MESSAGE);
            }
            //Verifica se o usuário deseja cadastrar mais atletas
            if(i == 9){
                break;
            }
            opcao = input("opcao", "Deseja cadastrar outro atleta?", "Continuar"
                    , JOptionPane.YES_NO_OPTION);
            
            if(opcao.equals("1")){
                break;
            }
        }
        JOptionPane.showMessageDialog(null, "Ordenando...","ALERTA!", 2);
        ordenar(atletas, notas, i);
        
    }
   
    //Metódo para conferir se o nome digitado é válido
    public static boolean lerNome(String atletas[], int i){
        String nome = input("input", "Digite o nome do "+ (i+1) +"º atleta: ",
                "Nome atleta", JOptionPane.PLAIN_MESSAGE);
        if(nome == null){
            //Caso a pessoa tente cancelar após ter cadastrado o primeiro atleta
            if(i > 0){
                JOptionPane.showMessageDialog(null,
                        "Selecione a opção 'NÃO' após cadastrar o próximo"
                                + "atleta...");
                return false;
            }
            else{
                JOptionPane.showMessageDialog(null, "Saindo do sistema...", 
                        "SAINDO" ,JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
                return false;
            }
        }
        //Caso o nome seja menor que duas letras
        if((nome.equals("")||(nome.length()<2))){
            return false;
        }
        else{
            atletas[i] = nome;
            return true;
        }
    }
    
    //Metódo para conferir se a nota digitada é válida
    public static boolean lerNotas(float notas[], int i){
        float nota;
        //Verifica se um número foi digitado
        try{
            nota = Float.parseFloat(input("input", "Digite a nota: ",
                    "Nota Atleta", JOptionPane.PLAIN_MESSAGE));
            //Caso a nota seja negativa ou maior que 10
            if((nota < 0)||(nota >10)){ 
                return false;
            }
            else{
                notas[i] = nota;
                return true;
            } 
        }
        //Caso uma letra seja digitada
        catch(NumberFormatException e){
            return false;
        }
    }
    
    //Método para ordenar os atletas cadastrados
    public static void ordenar(String atletas[], float notas[], int aux){
        int i, j;
        float auxFloat;
        String auxString;
        
        for(i = 0; i <= aux; i++){
            for(j = 0; j < i; j++){
                if(notas[i] > notas[j]){
                    //Ordena as notas
                    auxFloat = notas[i];
                    notas[i] = notas[j];
                    notas[j] = auxFloat;
                    //Ordena os nomes
                    auxString = atletas[i];
                    atletas[i] = atletas[j];
                    atletas[j] = auxString;
                }
            }
        }
        
        exibir(atletas, notas, aux);
    }

    //Método que exibe os atletas cadastrados
    public static void exibir(String atletas[], float notas[], int aux){
        String mensagem = "ATLETAS CADASTRADOS:\n";
        
        for(int i = 0; i <= aux; i++){
            mensagem = mensagem + "\nAtleta: " + atletas[i] +"\nNota: "
                    +notas[i]+"\n";
        }
        JOptionPane.showMessageDialog(null, mensagem, "Atletas:", 1);
        JOptionPane.showMessageDialog(null, null, "CADASTRO", 
                JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/iconFinal.png"));
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
