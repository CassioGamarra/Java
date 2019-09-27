package controller;
 
import java.awt.Color;
import javax.swing.JOptionPane;
import static model.ModelConfig.VAGA;
import model.ModelEntradaSaida;
import util.Util;
import view.ViewSistema;

/**
 * Classe Controller com os métodos de entrada e saida da garagem
 * @author cassio
 */
public class ControllerEntradaSaida {
    
    Util util = new Util();
    
    //Entrada da garagem
    public String entradaGaragem(ViewSistema view){
        
        String mensagem =  "";
        String placa, tipo;
        int vaga;
        
        placa = view.getFieldPlacaEntrada().getText();
        tipo = view.getFieldTipoVeiculo().getSelectedItem().toString();
        vaga = view.getTabelaVagas().getSelectedRow();
        
        placa = placa.toUpperCase();
        
        if(vaga < 0){
            JOptionPane.showMessageDialog(null, "SELECIONAR VAGA"
                    + "\nPor favor, selecione uma vaga!");
        }
        else if(!util.isPlaca(placa)){
            JOptionPane.showMessageDialog(null, "PLACA INVÁLIDA"
                    + "\nA placa digitada está incorreta");
        }
        else if(tipo.equals("") || tipo.equals("Selecione")){
            JOptionPane.showMessageDialog(null, "SELECIONAR TIPO"
                    + "\nPor favor, selecione um tipo!");
        }
        else if(!view.getTabelaVagas().getValueAt(vaga, 1).toString().equals("LIVRE")){
            JOptionPane.showMessageDialog(null, "VAGA OCUPADA"
                    + "\nPor favor, selecione uma vaga livre!");
        }
        else if(view.getTabelaVagas().getRowCount() == VAGA.size()){
            JOptionPane.showMessageDialog(null, "GARAGEM LOTADA"
                        + "\nDesculpe, a garagem está lotada!");
        }
        else{
            ModelEntradaSaida entradaSaida = new ModelEntradaSaida();
            mensagem = entradaSaida.entrada(placa, vaga, tipo);
            int posicao = vaga + 1;
            String msg[] = mensagem.split("-");
            String hora = msg[0];
            String data = msg[1];
            if(!mensagem.equals("")){
                view.getTabelaVagas().setValueAt("VAGA "+posicao+" OCUPADA", vaga, 0);
                view.getTabelaVagas().setValueAt(placa, vaga, 1);
                view.getTabelaVagas().setValueAt(tipo, vaga, 2);
                view.getLblPlacaCupom().setText(placa);
                view.getLblHoraEntradaCupom().setText("HORA: "+hora+" | DATA: "+data);
                view.getFieldPlacaEntrada().setText("");
            }
            return mensagem;
        }
        return mensagem;
    }
    
    //Saída da garagem
    public String saidaGaragem(ViewSistema view){
        
        String mensagem =  "";
        String placa, tipo;
        int vaga;
        
        placa = view.getFieldPlacaEntrada().getText();
        tipo = view.getFieldTipoVeiculo().getSelectedItem().toString();
        vaga = view.getTabelaVagas().getSelectedRow();
        
        placa = placa.toUpperCase();
        
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
                view.getTabelaVagas().setValueAt("LIVRE", vaga, 1);
                view.getTabelaVagas().setValueAt("LIVRE", vaga, 2);
            }
            util.cleanJTable(view.getTabelaHistorico());
            ControllerHistorico historico = new ControllerHistorico();
            historico.gerarHistorico(view);
            return mensagem;
        }
        return mensagem;
    }
}
