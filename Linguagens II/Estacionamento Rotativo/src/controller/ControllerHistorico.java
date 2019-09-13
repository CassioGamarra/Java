package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.ModelHistorico;
import view.ViewSistema;

/**
 * Controller do histórico
 * @author cassio
 */
public class ControllerHistorico {
    public ControllerHistorico(){}
    
    public void gerarHistorico(ViewSistema view){
        ModelHistorico historico = new ModelHistorico();
        ResultSet consulta = historico.gerarHistorico();
        
        DefaultTableModel model = (DefaultTableModel) view.getTabelaHistorico().getModel();
        String placa, dataEntrada, horaEntrada, dataSaida, horaSaida, tipoVeiculo;
        int vaga;
        try {
            while(consulta.next()){
                placa = consulta.getString("PLACA");
                vaga = consulta.getInt("VAGA");
                dataEntrada = consulta.getString("DATA_ENTRADA");
                horaEntrada = consulta.getString("HORA_ENTRADA");
                dataSaida = consulta.getString("DATA_SAIDA");
                horaSaida = consulta.getString("HORA_SAIDA");
                tipoVeiculo = consulta.getString("TIPO_VEICULO");
                Object[] linha = {placa, vaga, dataEntrada, horaEntrada, dataSaida, horaSaida, tipoVeiculo};
                model.addRow(linha);
            }
            
        }
        catch (SQLException ex) {
            Logger.getLogger(ControllerHistorico.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
    }
}
