package gerenciadordehorarios.controller;

import gerenciadordehorarios.view.ViewInicial;
import javax.swing.JOptionPane;

/**
 * Main do controller inicial
 * @author cassio
 */
public class ControllerInicial {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bem vindo!", "Gerenciador de Horários", JOptionPane.PLAIN_MESSAGE);
        ViewInicial view = new ViewInicial();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}
