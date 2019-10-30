package controller;

import view.ViewConfig;

/**
 *
 * @author cassio
 */
public class ControllerPrincipal {
    public static void main(String[] args) {
        /*ViewPrincipal view = new ViewPrincipal();
        view.setLocationRelativeTo(null);
        view.setVisible(true);*/
        ViewConfig view = new ViewConfig();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}
