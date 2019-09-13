package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.ModelHistorico;
import view.ViewSistema;

/**
 *
 * @author cassio
 */
public class ControllerHistorico {
    public ControllerHistorico(){}
    
    public void gerarHistorico(ViewSistema view){
        ModelHistorico historico = new ModelHistorico();
        ResultSet consulta = historico.gerarHistorico();
        int i = 0;
        try {
            while(consulta.next()){
                String placa = consulta.getString("PLACA");
                int vaga = consulta.getInt("VAGA");
                String dataEntrada = consulta.getString("DATA_ENTRADA");
                String horaEntrada = consulta.getString("HORA_ENTRADA");
                String dataSaida = consulta.getString("DATA_SAIDA");
                String horaSaida = consulta.getString("HORA_SAIDA");
                String tipoVeiculo = consulta.getString("TIPO_VEICULO");
               
                DefaultTableModel model = (DefaultTableModel) view.getTabelaHistorico().getModel();
                Object[] linha = {placa, vaga, dataEntrada, horaEntrada, dataSaida, horaSaida, tipoVeiculo};
                model.addRow(linha);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerHistorico.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
    }
}
