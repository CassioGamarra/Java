/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordehorarios.controller;

import gerenciadordehorarios.model.ModelTurma;
import gerenciadordehorarios.view.ViewAdministrador;

/**
 *
 * @author CPD
 */
public class ControllerTurma {
    public ControllerTurma(){}
    
    public void salvarTurma(ViewAdministrador view){
        ModelTurma turma = new ModelTurma();
        
        turma.setTurma(Integer.parseInt(view.getFieldTurmaTurma().getText()));
        turma.setTurno(view.getComboTurnoTurma().getSelectedItem().toString());
        turma.setNivel(view.getComboNivelTurma().getSelectedItem().toString());
        
        //Exibindo os valores salvos
        System.out.println(turma.getTurma());
        System.out.println(turma.getTurno());
        System.out.println(turma.getNivel());
    }
}
