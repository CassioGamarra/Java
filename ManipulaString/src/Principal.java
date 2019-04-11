/*
 * Classname             (Trabalhando com strings)
 * Version information   ()
 * Date                  ()
 * author                (Cássio Gamarra)
 */

public class Principal {

    /**
     * Manipulando strings
     */
    public static void main(String[] args) {
        String s  = "Java";
        int i;
        char c;
        
        i = s.length(); //Retorna o tamanho de uma string
        c = s.charAt(2); //Retorna o 3 caractere contido na string
        s = s.toUpperCase(); //Armazena S em caixa alta
        s = s.toLowerCase(); //Armazena S em caixa baixa
        s = s.substring(2); //Armazena S a partir da posição 2
        s = s.substring(1,3); //Entre um caractere inicial e final
        s = s.trim(); //Remove espaços em branco
        s = s.replace('a', 'x'); //Troca o valor de A por X
        s = s.concat("LP1"); //Concatena a string com LP1
        i = s.indexOf('v'); //Armazena em i a posição da primeira ocorrência de 'v' em string
        i = s.lastIndexOf('v'); 
        
    }
    
}
