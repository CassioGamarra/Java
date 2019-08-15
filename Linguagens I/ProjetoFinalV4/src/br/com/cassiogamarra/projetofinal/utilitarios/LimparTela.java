package br.com.cassiogamarra.projetofinal.utilitarios;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class LimparTela {
    public static void LimparTela(JFrame Frame) {     
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
