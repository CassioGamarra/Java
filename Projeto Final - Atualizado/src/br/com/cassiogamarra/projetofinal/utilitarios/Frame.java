package br.com.cassiogamarra.projetofinal.utilitarios;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Classe com os métodos para atualização do frame
 * @author Gnomo
 */
public class Frame {
    public static void limparFrame(JFrame Frame){
        for (int i=0; i < Frame.getContentPane().getComponentCount(); i++){
            Component c = Frame.getContentPane().getComponent(i); 
            if (c instanceof JTextField){
                JTextField field = (JTextField) c;
                field.setText("");
            }
        }
    }
}
