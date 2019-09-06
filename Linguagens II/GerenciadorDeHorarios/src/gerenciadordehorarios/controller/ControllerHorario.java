/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordehorarios.controller;

import gerenciadordehorarios.view.ViewAdministrador;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CPD
 */
public class ControllerHorario {
    public ControllerHorario(){
    }
    
    public void horarios(ViewAdministrador view){
        String turno = view.getComboTurnoHorarios().getSelectedItem().toString();
        DefaultTableModel model = (DefaultTableModel) view.getTabelaHorarios().getModel();
            
        if(turno.equals("TARDE")){
            Object[] linha1 = {"13h10"};
            Object[] linha2 = {"14h"};
            Object[] linha3 = {"14h45"};
            Object[] linha4 = {"15h50"};
            Object[] linha5 = {"16h40"};
            model.addRow(linha1);
            model.addRow(linha2);
            model.addRow(linha3);
            model.addRow(linha4);
            model.addRow(linha5);
        }
        else if(turno.equals("MANHÃ")){
            Object[] linha1 = {"7h40"};
            Object[] linha2 = {"8h30"};
            Object[] linha3 = {"9h15"};
            Object[] linha4 = {"10h15"};
            Object[] linha5 = {"11h15"};
            Object[] linha6 = {"12h00"};
            model.addRow(linha1);
            model.addRow(linha2);
            model.addRow(linha3);
            model.addRow(linha4);
            model.addRow(linha5);
            model.addRow(linha6);
        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione o turno!");
        }
    }
}
