/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulorh;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author cassio
 */
public class Cadastro {
    
    public static String nomeArquivo = "cidades_e_estados.sql";
    public static String uf = "";
    
    public Cadastro() {
    }
    
    public void cadastrar(JFrame frame){
        JOptionPane.showMessageDialog(null, "SUCESSO!" + "Tamanho" + frame.getSize());
    }
    
    public void listar(JFrame frame){
        
    }
}
    