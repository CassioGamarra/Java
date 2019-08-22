/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulorh;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    
    public void cadastrar(FormCadastro frame){
        Pessoa funcionario = new Pessoa();
        funcionario.setNome(frame.getTextNome().getText());
        funcionario.setEmail(frame.getTextEmail().getText());
        //Pega o valor do combo box
        int uf = frame.getComboBoxUF().getSelectedIndex();
        funcionario.setEstado(frame.getComboBoxUF().getItemAt(uf).toString());
        int cidade = frame.getComboBoxCidade().getSelectedIndex();
        funcionario.setCidade(frame.getComboBoxCidade().getItemAt(cidade).toString());
        
        
        
    }
    
    //listar cidades referente ao estado selecionado
    public void listarCidades(FormCadastro frame){
        int id, i, n;
        id = frame.getComboBoxUF().getSelectedIndex();
        //System.out.println(id);
    
        List<String> cidades;
    
        switch (id) {
            case 0:
                frame.getComboBoxCidade().removeAllItems();
                break;
            case 1:
                frame.getComboBoxCidade().removeAllItems();
                cidades = listaCidades("RS");
                n = cidades.size();
                frame.getComboBoxCidade().addItem("SELECIONE");
                for(i = 0; i < n; i++){
                    frame.getComboBoxCidade().addItem(cidades.get(i));
                }   break;
            case 2:
                frame.getComboBoxCidade().removeAllItems();
                cidades = listaCidades("SC");
                n = cidades.size();
                frame.getComboBoxCidade().addItem("SELECIONE");
                for(i = 0; i < n; i++){
                    frame.getComboBoxCidade().addItem(cidades.get(i));
                }   break;
            case 3:
                frame.getComboBoxCidade().removeAllItems();
                cidades = listaCidades("PR");
                n = cidades.size();
                frame.getComboBoxCidade().addItem("SELECIONE");
                for(i = 0; i < n; i++){
                    frame.getComboBoxCidade().addItem(cidades.get(i));
                }   break;
            default:
                System.out.println("ERRO!");
                break;
        }
    }
    //Procurar as cidades no arquivo e armazenar em uma lista
    private List<String> listaCidades(String uf){
        nomeArquivo = uf+".dat";
        File arquivo = new File(nomeArquivo);
        String cidade;
        List<String> cidades = new ArrayList<>();
        
        try {
            Scanner leitor = new Scanner(arquivo);
            while(leitor.hasNextLine()){
                cidade = leitor.nextLine();
                cidades.add(cidade);
            }
            
        }
        catch(FileNotFoundException e){
            System.out.println("Erro: "+e.getMessage());
        }
        return cidades;
    }
    
    //Métodos verificadores
    
    //Método para verificar se o nome é válido
    public boolean isNome(String nome){
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
    