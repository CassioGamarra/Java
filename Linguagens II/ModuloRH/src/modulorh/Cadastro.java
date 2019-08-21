/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulorh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author cassio
 */
public class Cadastro {
    
    public static String nomeArquivo = " ";
    public static String uf = "";
    
    public Cadastro() {
    }
    
    public void cadastrar(JFrame frame){
        JOptionPane.showMessageDialog(null, "SUCESSO!" + "Tamanho" + frame.getSize());
    }
    
    public void listar(FormCadastro frame){
        int id, i, n;
        String nomeArquivo = "";
        id = frame.getComboBoxUF().getSelectedIndex();
        System.out.println(id);
        /*Uso de um ArrayList para armazenar as cidades, facilitando assim
        a manipulação dos dados*/
        ArrayList<String> cidades = new ArrayList();
        
        if(id == 0){
            //?
        }
        else if(id == 1){
            frame.getComboBoxCidade().removeAllItems();
            cidades = listaCidades("RS");
            n = cidades.size();
            for(i = 0; i < n; i++){
                frame.getComboBoxCidade().addItem(cidades.get(i));
            }
        }
        else if(id == 2){
            frame.getComboBoxCidade().removeAllItems();
            frame.getComboBoxCidade().addItem("TESTE SC");
        }
        else if(id == 3){
            frame.getComboBoxCidade().removeAllItems();
            frame.getComboBoxCidade().addItem("TESTE PR");
        }
        else{
            System.out.println("ERRO!");
        }
    }
    private ArrayList<String> listaCidades(String uf){
        nomeArquivo = uf+".dat";
        File arquivo = new File(nomeArquivo);
        String cidade, estado, linha;
        ArrayList<String> cidades = new ArrayList();
        /*Uso de um ArrayList para armazenar as cidades, facilitando assim
        a manipulação dos dados*/
        try {
            Scanner leitor = new Scanner(arquivo);
            while(leitor.hasNextLine()){
                cidade = leitor.nextLine();
                cidades.add(cidade);
            }
            
        }
        catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
        return cidades;
    }
}
    