
import javax.swing.JOptionPane;

public class Cliente extends EntradaSaida{

    @Override
    public void entrada() {
        this.setSocio(false);
        this.setNumeroCartao(Integer.parseInt(JOptionPane.showInputDialog(null,
                "Número Cartão")));
        this.setConsumo(Float.parseFloat(JOptionPane.showInputDialog(null,
                "Consumo total:")));
        this.setValorEntrada(15);
    }

    @Override
    public double saida() {
        Calcular saida = new Calcular();
        float valorTotal;
        valorTotal = saida.calcular(this.getConsumo(), this.getValorEntrada());
        return valorTotal;
    }
}
