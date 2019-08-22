package modulorh;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Cadastro {
    
    public static String nomeArquivo = " ";
    public static String uf = "";
    
    public Cadastro() {
    }
    
    public void cadastrar(Pessoa pessoa){
        String msg = "Dados Cadastrados: \n";
        msg = msg + "\nNome: "+ pessoa.getNome()+
                "\nNome: "+ pessoa.getEmail()+
                "\nNome: "+ pessoa.getCidade()+
                "\nNome: "+ pessoa.getEstado();
        
        JOptionPane.showMessageDialog(null, "SUCESSO!");
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public void validarCadastro(FormCadastro frame){
        String nome = "";
        String email = "";
        String perfil = "";
        String escolaridade = "";
        String estadoCivil = "";
        String estado = "";
        String cidade  = "";
        
        nome = frame.getTextNome().getText();
        email = frame.getTextEmail().getText();
        int idUF, idCidade;
        idUF = frame.getComboBoxUF().getSelectedIndex();
        idCidade = frame.getComboBoxCidade().getSelectedIndex();
        estado = frame.getComboBoxUF().getItemAt(idUF).toString();
        cidade = frame.getComboBoxCidade().getItemAt(idCidade).toString();
        
        if(!isNome(nome)){
           System.out.println("Nome inválido!");
        }
        if(!isEmail(email)){
            frame.getTextEmail().setBackground(Color.red);
            System.out.println("Email inválido!");
        }
        else{
            Pessoa func = new Pessoa();
            func.setNome(nome);
            func.setEmail(email);
            func.setCidade(cidade);
            func.setEstado(estado);
            cadastrar(func);
        }
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
    
    //Método para verificar se o nome é válido
    public boolean isEmail(String email){
        String valor = email.toUpperCase();
        /*if(email.length() < 3){
            return false;
        }
        else{
            String regex = "^[[ ]|\\p{L}*]+$";
            return valor.matches(regex);
        }*/
        if(email.contains("@")){
            return true;
        }
        return false;
    }
}
    