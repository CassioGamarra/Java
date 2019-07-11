package gerenciadordecatracas.gerenciamento;

import java.awt.Component;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Classe com métodos uteis 
 * @author CassioGamarra
 */
public class Utilitario {
    //Método para recuperar a data e hora do sistema
    public String dataHoraSistema(){
        Calendar cal = new GregorianCalendar();
        String dataHoraAtual;
        
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int mes = cal.get(Calendar.MONTH);
        int ano = cal.get(Calendar.YEAR);
        int hora = cal.get(Calendar.HOUR);
        int minuto = cal.get(Calendar.MINUTE);
        int segundo = cal.get(Calendar.SECOND);
        
        dataHoraAtual = "Data: "+dia+"/"+(mes+1)+"/"+ano + " | " +"Hora: "+hora+":"+minuto+":"+segundo;
        
        return dataHoraAtual;
    }
    //Método para limpar um frame
    public void limparFrame(JFrame frame){
        for (int i=0; i < frame.getContentPane().getComponentCount(); i++){
            Component c = frame.getContentPane().getComponent(i);
            if (c instanceof JTextField){
                JTextField field = (JTextField) c;
                field.setText("");  
            }
        }
    }
    //Erro padrão para tabela inexistente
    public void erroTabela(){
        JOptionPane.showMessageDialog(null, "A TABELA NÃO EXISTE", "ERRO!", JOptionPane.WARNING_MESSAGE);
    }
}
