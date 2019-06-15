
package gerenciadordecatracas.gui;

public class AlterarComboBox {
    public static void alterarComboBox(FramePessoas frame){
        frame.getComboBoxCategoria();
        
        if(frame.getComboBoxCategoria().getSelectedItem() == "Aluno"){
            frame.getLblCategoria().setText("TURMA: ");
        }
        if(frame.getComboBoxCategoria().getSelectedItem() == "Responsável"){
            frame.getLblCategoria().setText("DEPENDENTES: ");
        }
        if(frame.getComboBoxCategoria().getSelectedItem() == "Colaborador"){
            frame.getLblCategoria().setText("CARGO: ");
        }
        if(frame.getComboBoxCategoria().getSelectedItem() == "Visitante"){
            frame.getLblCategoria().setText("OBSERVAÇÕES: ");
        }
    }
}
