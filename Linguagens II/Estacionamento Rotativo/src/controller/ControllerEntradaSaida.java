package controller;

import javax.swing.JOptionPane;
import model.ModelEntradaSaida;
import util.Util;
import view.ViewSistema;

/**
 *
 * @author cassio
 */
public class ControllerEntradaSaida {
    
    Util util = new Util();
    
    //Entrada catraca virtual manual
    public String entradaGaragem(ViewSistema view){
        
        String mensagem =  "";
        String placa, tipo;
        int vaga;
        
        placa = view.getFieldPlacaEntrada().getText();
        tipo = view.getFieldTipoVeiculo().getSelectedItem().toString();
        vaga = view.getTabelaVagas().getSelectedRow();
        System.out.println(vaga);
        if(!util.isPlaca(placa)){
            JOptionPane.showMessageDialog(null, "Placa Inválida!"
                    + "\nA placa possui 7 dígitos");
        }
        else{
            ModelEntradaSaida entradaSaida = new ModelEntradaSaida();
            mensagem = entradaSaida.entrada(placa, vaga, tipo);
            int posicao = vaga + 1;
            if(!mensagem.equals("")){
                view.getTabelaVagas().setValueAt("VAGA "+posicao+" OCUPADA", vaga, 0);
                view.getTabelaVagas().setValueAt(placa, vaga, 1);
                view.getTabelaVagas().setValueAt(tipo, vaga, 2);
            }
            return mensagem;
        }
        return mensagem;
    }
    
    //Saída catraca virtual manual
    public String saidaGaragem(ViewSistema view){
        
        String mensagem =  "";
        String placa, tipo;
        int vaga;
        
        placa = view.getFieldPlacaEntrada().getText();
        tipo = view.getFieldTipoVeiculo().getSelectedItem().toString();
        vaga = view.getTabelaVagas().getSelectedRow();
        
        if(!util.isPlaca(placa)){
            JOptionPane.showMessageDialog(null, "Placa inválida!"
                    + "\nA placa possuí 7 digitos");
        }
        else{
            ModelEntradaSaida entradaSaida = new ModelEntradaSaida();
            mensagem = entradaSaida.saida(placa, vaga);
            int posicao = vaga+1;
            if(!mensagem.equals("")){
                view.getTabelaVagas().setValueAt("VAGA "+posicao+"   |   LIVRE", vaga, 0);
                view.getTabelaVagas().setValueAt("", vaga, 1);
                view.getTabelaVagas().setValueAt("", vaga, 2);
            }
            return mensagem;
        }
        return mensagem;
    }
}
