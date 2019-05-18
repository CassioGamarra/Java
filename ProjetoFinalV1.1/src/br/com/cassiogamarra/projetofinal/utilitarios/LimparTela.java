/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cassiogamarra.projetofinal.utilitarios;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Gnomo
 */
public class LimparTela {
    public void LimparTela(JFrame Frame) {     
            //limpa os campos     
            for (int i=0; i < Frame.getContentPane().getComponentCount(); i++) {   
                //varre todos os componentes     
                Component c = Frame.getContentPane().getComponent(i);     
                if (c instanceof JTextField) {                           
                    JTextField field = (JTextField) c;   
                    field.setText("");                      
                    }   
                }   
            }
}
