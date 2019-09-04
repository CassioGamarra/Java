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
        if(turno.equals("MANHÃ")){
            DefaultTableModel model = (DefaultTableModel) view.getTabelaHorarios().getModel();
            
            Object[] linha = {"Teste"};
            
            model.addRow(linha);
        }
        else if(turno.equals("TARDE")){
            view.getTabelaHorarios().setValueAt("B", 1, 0);
        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione o turno!");
        }
    }
}
