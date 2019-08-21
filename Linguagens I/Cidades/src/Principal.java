/*
 * Classname             (Consultar Cidades)
 * Version information   (1.0)
 * Date                  (22.03.2019 23:30)
 * author                (Cássio Gamarra)
 */

import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Principal {
    
    public static String nomeArquivo = "cidades_e_estados.sql";
    public static String uf = "";
    
    public static void main(String[] args){
        JOptionPane.showMessageDialog(null, null, "CIDADES E ESTADOS", 
                JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/icon.png"));
        iniciar();
    }
    
    //Iniciar o programa
    public static void iniciar(){
        while(!lerEntrada()){
            JOptionPane.showMessageDialog(null,
                    "Por favor, digite uma entrada válida!",
                    "ERRO!", JOptionPane.WARNING_MESSAGE);
        }
        buscarCidades(uf);
    }
    
    //Método para validar a entrada do usuário
    public static boolean lerEntrada(){
        String nomeEstado = input("input", "Digite a sigla do estado: ",
                "CONSULTAR CIDADES", JOptionPane.PLAIN_MESSAGE);
        
        if(nomeEstado == null){
            JOptionPane.showMessageDialog(null, "Saindo do sistema...", "EXIT",
                    JOptionPane.INFORMATION_MESSAGE);
            System.exit(1);
        }
        if((nomeEstado.equals("")||(nomeEstado.length()!=2))){
            return false;
        }
        if(!nomeEstado.matches("[a-zA-Z\\s]+")){
            return false;
        }
        else{
            uf = nomeEstado.toUpperCase();
            return true;
        }
    }
    
    //Método para buscar as cidades no arquivo
    public static void buscarCidades(String uf){
        File arquivo = new File(nomeArquivo);
        int i, j, fim;
        String cidade, estado, linha;
        
        /*Uso de um ArrayList para armazenar as cidades, facilitando assim
        a manipulação dos dados*/
        ArrayList<String> cidades = new ArrayList();
        
        try{
            Scanner leitor = new Scanner(arquivo);
            
            while(leitor.hasNextLine()){
                linha = leitor.nextLine();
                
                if(linha.contains("INSERT") && linha.contains("tb_cidades")){
                    i = linha.indexOf("'");
                    j = linha.indexOf("',");
                    estado = linha.substring(i+1, j);
                    
                    if(uf.equals(estado)){
                        fim = linha.indexOf("');");
                        cidade = linha.substring(50, fim);
                        cidades.add(cidade);
                        
                    }
                }
            }        
        }
        
        catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
        
        exibir(cidades, uf);
    }
    
    //Método para exibir as cidades do respectivo estado
    public static void exibir(ArrayList<String> cidades, String uf){
        int i, n, opcao;
        n = cidades.size();
        
        String saida = "O estado do(a):  "+uf+" possui "+n+" municípios.";
        saida = saida + "\nOs municípios são:\n";
        
        //Se o tamanho do Array for 0, então o estado não existe
        if(n == 0){
            JOptionPane.showMessageDialog(null, "Você digitou um estado inválido!", "Entrada Inválida", JOptionPane.WARNING_MESSAGE);
            iniciar();
        }
        else{
            for(i = 0; i < n; i++){
                saida = saida+"\n"+cidades.get(i);
            }
                    
            /*Implementação de um JOptionPane com a função scroll
            para facilitar a visualização de estados com muitos municípios.
            Cria um objeto do tipo JTextArea de tamanho 30x30
            Altera a fonte para melhor visualização*/
            
            JTextArea texto = new JTextArea(30,30); 
            texto.setText(saida);
            texto.setFont(new Font("",Font.BOLD, 14));
            JScrollPane painel = new JScrollPane(texto);
            JOptionPane.showMessageDialog(null, painel, "CIDADES",
                    JOptionPane.PLAIN_MESSAGE);
            gravar(cidades, uf); //GRAVAR
            opcao = JOptionPane.showConfirmDialog(null, "Deseja realizar outra busca?", "CONTINUAR...", JOptionPane.YES_NO_OPTION);
            
            if(opcao == JOptionPane.YES_OPTION){
                iniciar(); //Executa o programa novamente
            }
            else{
                JOptionPane.showMessageDialog(null, null, "CIDADES E ESTADOS", 
                JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/iconFinal.png"));
            }
           
        }
        
    }
    //Método para gravar as cidades em um arquivo
    public static void gravar(ArrayList<String> cidades, String uf){
        int i, n;
        n = cidades.size();
        
        String nomeArquivo = uf+".dat"; //Nome do arquivo de saída
        
        try {
            FileWriter fw = new FileWriter(nomeArquivo);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(i = 0; i < n; i++){
                bw.write(cidades.get(i));
                bw.newLine();
            }
            bw.close();
            System.out.println("GRAVADO!");
            fw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
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
